package com.smartrecharge.processingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartrecharge.processingservice.entity.RechargeTransaction;

public interface RechargeTransactionRepository 
        extends JpaRepository<RechargeTransaction, Long> {

}