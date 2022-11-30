package com.comercia.rentalcar.model;

import java.math.BigDecimal;

import com.comercia.rentalcar.constants.Constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SmallPriceImpl implements Iprice {
	
	@Override
	public  BigDecimal getPrice() {
		return Constants.PRICE_SMALL;
	}
	

}
