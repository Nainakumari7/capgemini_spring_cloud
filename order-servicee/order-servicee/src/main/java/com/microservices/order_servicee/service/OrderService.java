package com.microservices.order_servicee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.order_servicee.entity.Orders;
import com.microservices.order_servicee.repository.OrderRepository;
import com.microservices.order_servicee.producer.OrderProducer;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private OrderProducer producer;

    public Orders createOrder(Orders order) {

        order.setStatus("CREATED");

        Orders savedOrder = repo.save(order);

        producer.sendOrder(savedOrder);

        return savedOrder;
    }

    public List<Orders> getOrders() {
        return repo.findAll();
    }

}