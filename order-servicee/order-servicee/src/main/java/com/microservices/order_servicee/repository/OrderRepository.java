package com.microservices.order_servicee.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.order_servicee.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}