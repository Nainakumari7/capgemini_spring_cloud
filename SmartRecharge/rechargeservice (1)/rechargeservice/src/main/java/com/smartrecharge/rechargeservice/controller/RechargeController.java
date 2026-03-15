package com.smartrecharge.rechargeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smartrecharge.rechargeservice.entity.Recharge;
import com.smartrecharge.rechargeservice.repository.RechargeRepository;
import com.smartrecharge.rechargeservice.service.RechargeService;

@RestController
@RequestMapping("/api/recharges")
public class RechargeController {

    @Autowired
    private RechargeService service;

    @Autowired
    private RechargeRepository repository;

    @PostMapping
    public Recharge createRecharge(@RequestBody Recharge recharge) {
        return service.createRecharge(recharge);
    }

    @GetMapping
    public List<Recharge> getAllRecharges() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Recharge getRechargeById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

}