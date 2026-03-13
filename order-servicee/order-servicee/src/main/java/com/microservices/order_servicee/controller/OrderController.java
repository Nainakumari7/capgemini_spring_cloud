package com.microservices.order_servicee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.microservices.order_servicee.entity.Orders;
import com.microservices.order_servicee.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        return service.createOrder(order);
    }

    @GetMapping
    public List<Orders> getOrders() {
        return service.getOrders();
    }
}