package com.microservices.book_service.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservices.book_service.config.RabbitConfig;
import com.microservices.book_service.service.BookService;


@Component
public class OrderConsumer {

    @Autowired
    private BookService service;

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void consume(OrderMessage message) {

        service.reduceStock(message.getBookId(), message.getQuantity());
    }
}