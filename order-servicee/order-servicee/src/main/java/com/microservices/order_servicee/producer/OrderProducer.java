package com.microservices.order_servicee.producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservices.order_servicee.config.RabbitConfig;


@Component
public class OrderProducer {

    @Autowired
    private RabbitTemplate template;

    public void sendOrder(Object message) {

        template.convertAndSend(RabbitConfig.QUEUE_NAME, message);
    }
}