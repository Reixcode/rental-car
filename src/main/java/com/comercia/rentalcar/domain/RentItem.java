package com.comercia.rentalcar.domain;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;


@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RentItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private TypeCar typeCar;
	
	@NotNull
	@Min(1)
	private Integer daysRent;
	
}
