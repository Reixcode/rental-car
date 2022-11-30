package com.comercia.rentalcar.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.comercia.rentalcar.entity.CarEntity;

public interface CarsApi {
	
	@GetMapping
    ResponseEntity<List<CarEntity>> findAll() ;
}
