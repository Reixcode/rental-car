package com.comercia.rentalcar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercia.rentalcar.api.CarsApi;
import com.comercia.rentalcar.entity.CarEntity;
import com.comercia.rentalcar.service.CarServiceImpl;


@RestController
@RequestMapping("/cars")
public class CarsController implements CarsApi{
	
	@Autowired 
	private CarServiceImpl service;

	@Override
	public ResponseEntity<List<CarEntity>> findAll() {
		
		return ResponseEntity.ok(service.findAll());
	}

}
