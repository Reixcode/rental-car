package com.comercia.rentalcar.domain;

import java.io.Serializable;
import java.math.BigDecimal;



import lombok.*;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReturnCarResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal totalSurchage ;

}
