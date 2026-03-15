package com.smartrecharge.customerservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    private String customerName;
    private String email;
    private String mobileNumber;
    private String city;
    private LocalDate registrationDate;
}