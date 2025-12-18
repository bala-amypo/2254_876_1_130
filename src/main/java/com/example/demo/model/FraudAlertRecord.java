package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;

    @Column(nullable = false)
    private String alertReason;

    @Column(nullable = false)
    private String status; // "PENDING" or "RESOLVED"

    public FraudAlertRecord() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClaimId() { return claimId; }
    public void setClaimId(Long claimId) { this.claimId = claimId; }

    public String getAlertReason() { return alertReason; }
    public void setAlertReason(String alertReason) { this.alertReason = alertReason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
