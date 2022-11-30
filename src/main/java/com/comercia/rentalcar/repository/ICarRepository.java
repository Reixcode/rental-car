package com.comercia.rentalcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercia.rentalcar.entity.CarEntity;


@Repository
public interface ICarRepository extends JpaRepository<CarEntity, Integer> {

}
