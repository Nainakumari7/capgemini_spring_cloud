package com.smartrecharge.rechargeservice.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartrecharge.rechargeservice.entity.Recharge;
import com.smartrecharge.rechargeservice.repository.RechargeRepository;
import com.smartrecharge.rechargeservice.producer.RechargeProducer;

@Service
public class RechargeService {

    @Autowired
    private RechargeRepository repository;

    @Autowired
    private RechargeProducer producer;

    public Recharge createRecharge(Recharge recharge) {

        recharge.setRechargeStatus("PENDING");
        recharge.setRequestTime(LocalDateTime.now());

        Recharge savedRecharge = repository.save(recharge);

        producer.sendRecharge(savedRecharge);

        return savedRecharge;
    }

}