package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyClaimRecord {

    private Long id;
    private String claimNumber;
    private String productName;
    private String productSerialNumber;

    private LocalDate purchaseDate;
    private LocalDate claimDate;

    private String issueDescription;
    private String status;   // APPROVED / REJECTED / PENDING
    private Double claimAmount;

    private String customerName;
    private String customerEmail;
    private String customerPhone;
}
