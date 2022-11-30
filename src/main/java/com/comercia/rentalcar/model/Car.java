package com.comercia.rentalcar.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

import com.comercia.rentalcar.constants.Constants;


import lombok.Data;

@Data
public class Car {

	private Car () {}
	
	/**
	 * Metodo que calcula los recargos por dias extras si existen
	 * @param Car
	 * @param days
	 * @return BigDecimal
	 */
	public static BigDecimal getPriceSurchage ( Icar icar , Integer days) {
		return  icar.getSurchageByDay().multiply(BigDecimal.valueOf(days)).setScale(Constants.NUMDECIMAL);
		
	}

	/**
	 * Metodo que calcula los puntos por alquiler de un coche
	 * @param Car
	 * @return Integer
	 */
	public static Integer getPoints ( Icar icar) {
		return  icar.getPoints();
		
	}
	
	/**
	 * Metodo que calcula el precio TOTAL de alquilar un coche concreto para todos los dias indicados teniendo en cuent alos tramos
	 * @param Car
	 * @param days
	 * @return BigDecimal
	 */
	
	public static BigDecimal getPriceByCar (Icar icar,Integer days) {
		 List<StepItem> steps= icar.getSteps();
		
		 return IntStream.iterate(1, i -> i + 1)
	        .limit(days).boxed().map(i ->calculatePriceByDay(i, steps)).reduce(BigDecimal::add).orElse(Constants.ZERO);
       
	
	}

	/**
	 * Metodo que instanica el tipo de coche elegido
	 * @param Car
	 * @param days
	 * @return BigDecimal
	 */
	public static Icar chooseTypeCar (String typeCar) {
		if (typeCar.equals("SUV")) {
			return new CarSuvImpl();
		}else if (typeCar.equals("PREMIUM")) {
			return new CarPremiumImpl();
		}else {
			return new CarSmallImpl();
		}
	}
	
	/**
	 * Metodo que calcula el precio segun los tramos 
	 * @param days
	 * @param StepItem
	 * @return BigDecimal
	 */

	private static BigDecimal calculatePriceByStep (Integer days, StepItem stepItem) {
		if (stepItem.getPredicate().test(days)) {
           return stepItem.getPrice();
        }else {
        	return  new BigDecimal(0);
        }
		
	}
	/**
	 * Metodo que calcula el precio en un dia concreto segun los tramos 
	 * @param days
	 * @param Steps
	 * @return BigDecimal
	 */
	private static BigDecimal calculatePriceByDay (Integer dayRent, List<StepItem> steps) {
		
		
		return steps.stream().map( p-> calculatePriceByStep(dayRent, p)).reduce(BigDecimal::add).orElse(Constants.ZERO);
		

	}
}
