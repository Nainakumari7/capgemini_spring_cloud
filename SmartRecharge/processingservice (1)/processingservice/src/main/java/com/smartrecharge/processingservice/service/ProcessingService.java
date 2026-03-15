package com.smartrecharge.processingservice.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartrecharge.processingservice.entity.RechargeTransaction;
import com.smartrecharge.processingservice.repository.RechargeTransactionRepository;

@Service
public class ProcessingService {

    @Autowired
    private RechargeTransactionRepository repository;

    public RechargeTransaction processRecharge(RechargeTransaction transaction) {

        transaction.setProcessingStatus("SUCCESS");
        transaction.setRemarks("Recharge processed successfully");
        transaction.setProcessedTime(LocalDateTime.now());

        return repository.save(transaction);
    }

}