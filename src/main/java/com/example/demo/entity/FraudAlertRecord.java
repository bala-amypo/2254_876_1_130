package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "claim_id", nullable = false)
    private Long claimId;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String alertType;

    @Column(nullable = false)
    private String severity; // LOW/MEDIUM/HIGH/CRITICAL

    private String message;

    @Column(nullable = false, updatable = false)
    private LocalDateTime alertDate;

    @Column(nullable = false)
    private Boolean resolved = false;

    @ManyToOne
    @JoinColumn(name = "claim_id", insertable = false, updatable = false)
    @JsonIgnore
    private WarrantyClaimRecord claim;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // --- Constructors ---

    public FraudAlertRecord() {
        // Default constructor required by JPA
    }

    public FraudAlertRecord(Long id, Long claimId, String serialNumber, String alertType,
                            String severity, String message, LocalDateTime alertDate,
                            Boolean resolved, WarrantyClaimRecord claim, User user) {
        this.id = id;
        this.claimId = claimId;
        this.serialNumber = serialNumber;
        this.alertType = alertType;
        this.severity = severity;
        this.message = message;
        this.alertDate = alertDate;
        this.resolved = resolved != null ? resolved : false;
        this.claim = claim;
        this.user = user;
    }

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClaimId() { return claimId; }
    public void setClaimId(Long claimId) { this.claimId = claimId; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getAlertDate() { return alertDate; }
    public void setAlertDate(LocalDateTime alertDate) { this.alertDate = alertDate; }

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }

    public WarrantyClaimRecord getClaim() { return claim; }
    public void setClaim(WarrantyClaimRecord claim) { this.claim = claim; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    // --- JPA PrePersist ---

    @PrePersist
    public void prePersist() {
        if (alertDate == null) alertDate = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }
}
