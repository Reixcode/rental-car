package com.comercia.rentalcar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercia.rentalcar.entity.CustomerEntity;

import com.comercia.rentalcar.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
    private ICustomerRepository clientRepo;
	
	
	@Override
    public Optional<CustomerEntity> findById(Integer id) {
        return clientRepo.findById(id);
    }

    @Override
    public CustomerEntity create(CustomerEntity cliente) {
        return clientRepo.save(cliente);
    }

    @Override
    public CustomerEntity updatePoints(Integer id, Integer points ) {
    	CustomerEntity result = clientRepo.findById(id).orElse(new CustomerEntity(id,0));
    	result.setPoints(result.getPoints()+points);
        return clientRepo.save(result);
    }
}
