package com.comercia.rentalcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercia.rentalcar.api.CustomersApi;
import com.comercia.rentalcar.entity.CustomerEntity;
import com.comercia.rentalcar.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class CustomersController implements CustomersApi {

	@Autowired 
	private CustomerServiceImpl service;
	
	@Override
	public ResponseEntity<CustomerEntity> findById(Integer idCustomer) {
		  return service.findById(idCustomer)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	}

}
