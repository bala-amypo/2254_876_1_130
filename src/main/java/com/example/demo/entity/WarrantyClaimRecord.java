package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyClaimRecord {

    private Long id;
    private String claimNumber;
    private String productCode;
    private boolean fraudulent;
}
