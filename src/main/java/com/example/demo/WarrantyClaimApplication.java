package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WarrantyClaimApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarrantyClaimApplication.class, args);
        System.out.println("=== Warranty Claim Fraud Detector Application Started ===");
    }
}
