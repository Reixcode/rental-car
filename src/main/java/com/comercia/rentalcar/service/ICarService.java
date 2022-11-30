package com.comercia.rentalcar.service;

import java.util.List;

import com.comercia.rentalcar.entity.CarEntity;


public interface ICarService {

	
	List<CarEntity> findAll();
}
