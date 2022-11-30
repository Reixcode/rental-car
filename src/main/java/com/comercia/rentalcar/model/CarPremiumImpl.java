package com.comercia.rentalcar.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.comercia.rentalcar.constants.Constants;




public class CarPremiumImpl  implements Icar{

	@Override
	public BigDecimal getSurchageByDay () {
		BigDecimal pricePremium = Price.getBasePrice(new PremiumPriceImpl());
		return pricePremium.add(pricePremium.multiply(Constants.SURCHAGE_PREMIUM));
	}
	
	@Override
	public Integer getPoints () {
		return 5;
	}
	
	@Override
	public List<StepItem> getSteps (){
		List<StepItem> stepsPredicate = new ArrayList<>();
		BigDecimal pricePremium = Price.getBasePrice(new PremiumPriceImpl());
		StepItem item = new StepItem();
		item.setPredicate( p -> p>0);
		item.setPrice(pricePremium);
		stepsPredicate.add(item);
		
		return stepsPredicate;
		
	}
}