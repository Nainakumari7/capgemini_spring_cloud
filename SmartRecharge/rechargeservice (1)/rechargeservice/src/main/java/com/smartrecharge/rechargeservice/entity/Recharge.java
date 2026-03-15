package com.smartrecharge.rechargeservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Recharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rechargeId;

    private Long customerId;
    private String mobileNumber;
    private String operatorName;
    private double amount;

    private String rechargeStatus;

    private LocalDateTime requestTime;

    public Recharge() {
    }

	public Long getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRechargeStatus() {
		return rechargeStatus;
	}

	public void setRechargeStatus(String rechargeStatus) {
		this.rechargeStatus = rechargeStatus;
	}

	public LocalDateTime getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
	}
    
    

}