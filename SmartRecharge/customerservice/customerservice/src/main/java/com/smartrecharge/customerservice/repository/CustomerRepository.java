package com.smartrecharge.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartrecharge.customerservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}