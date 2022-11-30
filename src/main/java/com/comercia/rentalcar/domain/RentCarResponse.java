package com.comercia.rentalcar.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RentCarResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("ListPriceRent")
	private List<PriceItem> listPriceRent;
	
	private BigDecimal totalRent;
	private Integer rentPoints;
	private Integer totalCustomerPoints;
	
}
