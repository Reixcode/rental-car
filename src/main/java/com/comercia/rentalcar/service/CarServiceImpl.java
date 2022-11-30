package com.comercia.rentalcar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercia.rentalcar.entity.CarEntity;
import com.comercia.rentalcar.repository.ICarRepository;

@Service
public class CarServiceImpl implements ICarService {
	
	 @Autowired
	 private ICarRepository carRepo;
	 
	 
	 @Override
	 public List<CarEntity> findAll() {
		 
	        return carRepo.findAll();
	    }

}
