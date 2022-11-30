package com.comercia.rentalcar.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.comercia.rentalcar.constants.Constants;



public class CarSuvImpl implements Icar{
	
	
	@Override
	public BigDecimal getSurchageByDay () {
		BigDecimal priceSuv = Price.getBasePrice(new SuvPriceImpl());
		BigDecimal priceSmall = Price.getBasePrice(new SmallPriceImpl());
		return priceSuv.add(priceSmall.multiply(Constants.SURCHAGE_SUV));
	}
	
    @Override
	public Integer getPoints () {
		return Constants.POINTS_SUV;
	}
	
	@Override
	public  List<StepItem> getSteps (){
		List<StepItem> stepsPredicate = new ArrayList<>();
		BigDecimal priceSuv = Price.getBasePrice(new SuvPriceImpl());
		StepItem item = new StepItem();
		item.setPredicate( p -> p>0 && p<=7);
		item.setPrice(priceSuv);
		stepsPredicate.add(item);
		
		item = new StepItem();
		item.setPredicate( p -> p>7 && p<=30);
		item.setPrice(priceSuv.multiply(BigDecimal.valueOf(0.8)).setScale(Constants.NUMDECIMAL));
		stepsPredicate.add(item);
		
		item = new StepItem();
		item.setPredicate( p -> p>30);
		item.setPrice(priceSuv.multiply(BigDecimal.valueOf(0.5)));
		stepsPredicate.add(item);
		
		return stepsPredicate;
	}
}
