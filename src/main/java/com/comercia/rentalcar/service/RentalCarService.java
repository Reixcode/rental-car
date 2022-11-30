package com.comercia.rentalcar.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.comercia.rentalcar.constants.Constants;
import com.comercia.rentalcar.domain.PriceItem;
import com.comercia.rentalcar.domain.RentCarResponse;
import com.comercia.rentalcar.domain.RentCarTO;
import com.comercia.rentalcar.domain.ReturnCarResponse;
import com.comercia.rentalcar.domain.ReturnCarTO;

import com.comercia.rentalcar.model.Car;


@Service
public class RentalCarService {
	
	private RentalCarService() {}
	
	
	
	/**
	 * Servico  que calcula el precio y puntos de alquiler de 1 o varios coches 
	 * @param RentCarTO
	 * @return RentCarResponse
	 */
	public RentCarResponse rentCarService (RentCarTO rentCarTo ) {
		
		RentCarResponse rentCarResponse = new RentCarResponse();
	
		
		List<PriceItem> list = rentCarTo.getCarRentList().stream().map(item-> new PriceItem (
					item.getTypeCar(),
					Car.getPriceByCar(Car.chooseTypeCar(item.getTypeCar().toString()), item.getDaysRent()),
					Car.getPoints(Car.chooseTypeCar(item.getTypeCar().toString()))
					)).collect(Collectors.toList());
						
		rentCarResponse.setListPriceRent(list);
		rentCarResponse.setRentPoints(list.stream().map(PriceItem::getPointsRent).reduce(Integer::sum).orElse(0));
		rentCarResponse.setTotalRent(list.stream().map(PriceItem::getPriceRent).reduce(BigDecimal::add).orElse(Constants.ZERO));
		
		return rentCarResponse;
	}
	
	
	/**
	 * Servico  que calcula el recargo por dias extras si procede 
	 * @param ReturnCarTO
	 * @return ReturnCarResponse
	 */
	public ReturnCarResponse returnCarService (ReturnCarTO returnCarTo ) {
		
		ReturnCarResponse returnCarResponse = new ReturnCarResponse();
		
		BigDecimal totalPrice = Car.getPriceSurchage(Car.chooseTypeCar(returnCarTo.getTypeCar().toString()),returnCarTo.getExtraDaysRent() );
		returnCarResponse.setTotalSurchage(totalPrice);
		return returnCarResponse;
	}
	
	
}
