package com.comercia.rentalcar.api;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.comercia.rentalcar.domain.RentCarResponse;
import com.comercia.rentalcar.domain.RentCarTO;
import com.comercia.rentalcar.domain.ReturnCarResponse;
import com.comercia.rentalcar.domain.ReturnCarTO;



public interface RentalCarApi {

	
	@PostMapping(value = "/rentcar/{idCustomer}",
	        produces = { "application/json" }, 
	        consumes = { "application/json" })
	
	 ResponseEntity<RentCarResponse> rentCar(@PathVariable("idCustomer") Integer idCustomer, @RequestBody @Valid RentCarTO rentCarTO);
	
	
	@PostMapping(value = "/returncar",
	        produces = { "application/json" }, 
	        consumes = { "application/json" })
	
	 ResponseEntity<ReturnCarResponse> returnCar( @RequestBody @Valid ReturnCarTO returnCarTO);
			 
	
      
	
}
