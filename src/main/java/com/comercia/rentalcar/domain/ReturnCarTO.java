package com.comercia.rentalcar.domain;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReturnCarTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Valid
	private TypeCar typeCar;
	
	@NotNull
	@PositiveOrZero
	@Valid
	private Integer extraDaysRent;

}
