package com.example.demo.model;

import java.time.LocalDateTime;

public class WarrantyClaimRecord {
    private Long id;
    private String serialNumber;
    private String claimReason;
    private String status;
    private LocalDateTime submittedAt;
    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public String getClaimReason() { return claimReason; }
    public String getStatus() { return status; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public void setClaimReason(String claimReason) { this.claimReason = claimReason; }
    public void setStatus(String status) { this.status = status; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
