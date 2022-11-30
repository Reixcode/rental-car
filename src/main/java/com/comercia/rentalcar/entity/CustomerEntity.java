package com.comercia.rentalcar.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
	
	@Id
	@Column(name = "ID_CUSTOMER")
	private Integer idCustomer;
	@NotNull
	@Min(0)
	@Column(name = "POINTS")
    private Integer points;
}
