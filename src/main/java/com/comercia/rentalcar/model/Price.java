package com.comercia.rentalcar.model;

import java.math.BigDecimal;


public class Price {

	private Price () {}
	
	/**
	 * Metodo que calcula el precio segun la instancia de tipo de precio
	 * @param Price
	 * @return BigDecimal
	 */
	public static BigDecimal getBasePrice ( Iprice iPrice) {
		return  iPrice.getPrice();
		
	}
}
