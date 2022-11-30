package com.comercia.rentalcar.model;

import java.math.BigDecimal;
import java.util.function.Predicate;



public class StepItem {
	 Predicate<Integer> predicate;

	 BigDecimal price;
	
	public Predicate<Integer> getPredicate() {
		return predicate;
	}
	public void setPredicate(Predicate<Integer> predicate) {
		this.predicate = predicate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	 
}
