package com.comercia.rentalcar.model;

import java.math.BigDecimal;
import java.util.List;

public interface Icar {
	 
	
	BigDecimal getSurchageByDay ();
	 
	 Integer getPoints ();
	 
	 List<StepItem> getSteps ();

}
