package com.comercia.rentalcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercia.rentalcar.entity.CustomerEntity;


@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
