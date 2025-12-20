package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

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

    // No-args constructor
    public FraudAlertRecord() {
    }

    // Core fields constructor
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

    // Auto-generate alertDate
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

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public LocalDateTime getAlertDate() {
        return alertDate;
    }
}
