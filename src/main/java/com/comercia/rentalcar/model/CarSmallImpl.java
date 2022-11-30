package com.comercia.rentalcar.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.comercia.rentalcar.constants.Constants;


public class CarSmallImpl implements Icar{

	
	@Override
	public BigDecimal getSurchageByDay () {
		BigDecimal priceSmall = Price.getBasePrice(new SmallPriceImpl());
		return priceSmall.add(priceSmall.multiply(Constants.SURCHAGE_SMALL));
		
	}
	
	@Override
	public Integer getPoints () {
		return Constants.POINTS_SMALL;
	}
	
	@Override
	public List<StepItem> getSteps (){
		List<StepItem> stepsPredicate = new ArrayList<>();
		BigDecimal priceSmall = Price.getBasePrice(new SmallPriceImpl());
		StepItem item = new StepItem();
		item.setPredicate( p -> p>0 && p<=7);
		item.setPrice(priceSmall);
		stepsPredicate.add(item);
		
		item = new StepItem();
		item.setPredicate( p -> p>7 );
		item.setPrice(priceSmall.multiply(BigDecimal.valueOf(0.6)));
		stepsPredicate.add(item);
		
		
		return stepsPredicate;
	}
}
