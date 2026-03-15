package com.smartrecharge.processingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.smartrecharge.processingservice.entity.RechargeTransaction;
import com.smartrecharge.processingservice.repository.RechargeTransactionRepository;

@RestController
@RequestMapping("/api/transactions")
public class ProcessingController {

    @Autowired
    private RechargeTransactionRepository repository;

    @GetMapping
    public List<RechargeTransaction> getAllTransactions() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public RechargeTransaction getTransactionById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

}