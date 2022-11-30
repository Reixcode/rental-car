package com.comercia.rentalcar.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.comercia.rentalcar.entity.CustomerEntity;

public interface CustomersApi {
	

	@GetMapping(value = "/{idCustomer}")
    ResponseEntity<CustomerEntity> findById(@PathVariable("idCustomer") Integer idCustomer) ;


}
