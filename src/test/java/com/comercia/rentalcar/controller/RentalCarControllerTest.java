package com.comercia.rentalcar.controller;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import com.comercia.rentalcar.constants.Constants;
import com.comercia.rentalcar.domain.RentCarResponse;
import com.comercia.rentalcar.domain.RentCarTO;
import com.comercia.rentalcar.domain.RentItem;
import com.comercia.rentalcar.domain.ReturnCarResponse;
import com.comercia.rentalcar.domain.ReturnCarTO;
import com.comercia.rentalcar.domain.TypeCar;
import com.comercia.rentalcar.entity.CustomerEntity;
import com.comercia.rentalcar.service.CustomerServiceImpl;
import com.comercia.rentalcar.service.RentalCarService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.module.mockmvc.RestAssuredMockMvc;




@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RentalCarControllerTest {
	

	@Autowired
	private MockMvc mockMvc;
	

	@Autowired
	RentalCarController controller;
	
	@MockBean
	private CustomerServiceImpl customerService;
	@MockBean
	private RentalCarService rentalCarService;

	
    @BeforeEach
    void setup(){
    	MockitoAnnotations.openMocks(this);
    
    	RestAssuredMockMvc.standaloneSetup(	controller);
    }
	@Test
	void rentCar () {
		CustomerEntity customerEntity = new  CustomerEntity();
		customerEntity.setIdCustomer(1);
		customerEntity.setPoints(10);

		
		RentCarResponse rentCarResponse = new RentCarResponse();
		rentCarResponse.setRentPoints(9);
		
		Mockito.when(customerService.updatePoints(Mockito.anyInt(),Mockito.anyInt())).thenReturn(customerEntity); 
		Mockito.when(rentalCarService.rentCarService(Mockito.any(RentCarTO.class))).thenReturn(rentCarResponse); 
		
		
		RestAssuredMockMvc.given()
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.body(tentCarTOTest())
		.when()
		.post("/rentalcar/rentcar/{id}",1)
		.then()
		.log().ifValidationFails()
		.statusCode(HttpStatus.CREATED.value());
	
	}
	@Test
	void returncar () {
		ReturnCarResponse returnCar = new ReturnCarResponse();
		returnCar.setTotalSurchage(Constants.ZERO);
		ReturnCarTO returnCarTO = new ReturnCarTO();
		returnCarTO.setExtraDaysRent(0);
		returnCarTO.setTypeCar(TypeCar.PREMIUM);
		Mockito.when(rentalCarService.returnCarService(Mockito.any(ReturnCarTO.class))).thenReturn(returnCar); 
		
		
		RestAssuredMockMvc.given()
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.body(returnCarTO)
		.when()
		.post("/rentalcar/returncar")
		.then()
		.log().ifValidationFails()
		.statusCode(HttpStatus.CREATED.value());
	
	}
	private RentCarTO tentCarTOTest () {
		RentCarTO rentCarTO = new RentCarTO();
		List<RentItem> list =new ArrayList<>();
		RentItem item =new RentItem();
		item.setDaysRent(1);
		item.setTypeCar(TypeCar.PREMIUM);
		list.add(item);
		
		rentCarTO.setCarRentList(list);
		return rentCarTO;
	}
	
}
