package com.smartrecharge.rechargeservice.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smartrecharge.rechargeservice.entity.Recharge;

@Component
public class RechargeProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String QUEUE_NAME = "recharge_queue";

    public void sendRecharge(Recharge recharge) {

        rabbitTemplate.convertAndSend(QUEUE_NAME, recharge);

        System.out.println("Recharge request sent to queue: " + recharge.getRechargeId());
    }

}