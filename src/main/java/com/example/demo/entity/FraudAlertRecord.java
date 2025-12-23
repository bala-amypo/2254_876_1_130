package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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
    private String severity;

    private String message;

    @Column(nullable = false)
    private Boolean resolved = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime alertDate;

    @ManyToOne
    @JoinColumn(name = "claim_ref_id")
    private WarrantyClaimRecord claim;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public FraudAlertRecord() {
    }

    public FraudAlertRecord(Long claimId, String serialNumber, String alertType, String severity) {
        this.claimId = claimId;
        this.serialNumber = serialNumber;
        this.alertType = alertType;
        this.severity = severity;
        this.resolved = false;
    }

    @PrePersist
    protected void onCreate() {
        this.alertDate = LocalDateTime.now();
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    public Long getId() {
        return id;
    }

    public Long getClaimId() {
        return claimId;
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

    public LocalDateTime getAlertDate() {
        return alertDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public void setClaim(WarrantyClaimRecord claim) {
        this.claim = claim;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
