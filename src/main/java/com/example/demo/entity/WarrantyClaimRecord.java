package com.example.demo.model;

import java.time.LocalDateTime;

public class WarrantyClaimRecord {
    private Long id;
    private String claimNumber;
    private LocalDateTime submittedAt;
    private LocalDateTime createdAt;

    public void setId(Long id) { this.id = id; }
    public void setClaimNumber(String claimNumber) { this.claimNumber = claimNumber; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
