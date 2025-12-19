package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long claimId;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String alertType;

    @Column(nullable = false)
    private String severity; // LOW, MEDIUM, HIGH, CRITICAL

    private String message;

    @Column(nullable = false)
    private Boolean resolved = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime alertDate;

    // ✅ No-args constructor
    public FraudAlertRecord() {
    }

    // ✅ Core fields constructor
    public FraudAlertRecord(
            Long claimId,
            String serialNumber,
            String alertType,
            String severity,
            String message) {

        this.claimId = claimId;
        this.serialNumber = serialNumber;
        this.alertType = alertType;
        this.severity = severity;
        this.message = message;
        this.resolved = false;
    }

    // ✅ Auto-generate alertDate
    @PrePersist
    protected void onCreate() {
        this.alertDate = LocalDateTime.now();
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    // =======================
    // Getters and Setters
    // =======================

    public Long getId() {
        return id;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getAlertType() {
        return alertType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getResolved() {
        return resolved;
    }

    // ✅ THIS IS THE FIX YOU ASKED FOR
    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public LocalDateTime getAlertDate() {
        return alertDate;
    }
}
