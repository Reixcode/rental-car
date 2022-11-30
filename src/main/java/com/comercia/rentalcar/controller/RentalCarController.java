package com.comercia.rentalcar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercia.rentalcar.api.RentalCarApi;
import com.comercia.rentalcar.domain.RentCarResponse;
import com.comercia.rentalcar.domain.RentCarTO;
import com.comercia.rentalcar.domain.ReturnCarResponse;
import com.comercia.rentalcar.domain.ReturnCarTO;
import com.comercia.rentalcar.entity.CustomerEntity;
import com.comercia.rentalcar.service.CustomerServiceImpl;
import com.comercia.rentalcar.service.RentalCarService;


import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/rentalcar")
public class RentalCarController implements RentalCarApi {
	
	@Autowired 
	CustomerServiceImpl customerService;
	
	@Autowired 
	RentalCarService rentalCarService;
	
	@Override
	public ResponseEntity<RentCarResponse> rentCar( Integer idCustomer,RentCarTO rentCarTO){
		RentCarResponse rentCarResponse = rentalCarService.rentCarService(rentCarTO);
		
		CustomerEntity customerEntity =customerService.updatePoints(idCustomer, rentCarResponse.getRentPoints());
		rentCarResponse.setTotalCustomerPoints(customerEntity.getPoints());
		return new ResponseEntity<>(rentCarResponse,HttpStatus.CREATED);
	}	
	
	@Override
	public ResponseEntity<ReturnCarResponse> returnCar( ReturnCarTO returnCarTO){
		ReturnCarResponse returnCarResponse = rentalCarService.returnCarService(returnCarTO);
		return new ResponseEntity<>(returnCarResponse,HttpStatus.CREATED);
	}
	


}
