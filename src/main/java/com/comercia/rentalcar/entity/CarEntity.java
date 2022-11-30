package com.comercia.rentalcar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="CAR")
public class CarEntity {
	@Id
	@Column(name = "ID_CAR")
	private String idCar;
	@Column(name = "TYPE_CAR")
	private String typeCar;
	

}
