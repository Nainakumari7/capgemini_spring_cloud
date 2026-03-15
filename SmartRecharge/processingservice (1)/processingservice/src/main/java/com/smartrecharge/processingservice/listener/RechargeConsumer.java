package com.smartrecharge.processingservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smartrecharge.processingservice.entity.RechargeTransaction;
import com.smartrecharge.processingservice.service.ProcessingService;

@Component
public class RechargeConsumer {

    @Autowired
    private ProcessingService processingService;

    @RabbitListener(queues = "recharge_queue")
    public void processRecharge(RechargeTransaction transaction) {

        System.out.println("Received Recharge Request: " + transaction.getRechargeId());

        processingService.processRecharge(transaction);
    }

}