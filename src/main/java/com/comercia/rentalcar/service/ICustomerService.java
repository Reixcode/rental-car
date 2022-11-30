package com.comercia.rentalcar.service;

import java.util.Optional;

import com.comercia.rentalcar.entity.CustomerEntity;


public interface ICustomerService {
	
	 Optional<CustomerEntity> findById(Integer id);
	 
	 CustomerEntity create(CustomerEntity clientEntity);

	 CustomerEntity updatePoints(Integer idCustomer, Integer points);
}
