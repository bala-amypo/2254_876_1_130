package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String claimantName;

    private String claimantEmail;

    @Column(nullable = false)
    private String claimReason;

    @Column(nullable = false)
    private String status = "PENDING"; // PENDING/APPROVED/REJECTED/FLAGGED

    @Column(nullable = false)
    private LocalDateTime submittedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private DeviceOwnershipRecord device;

    @OneToMany(mappedBy = "claimId", cascade = CascadeType.ALL)
    private List<FraudAlertRecord> fraudAlerts = new ArrayList<>();

    public WarrantyClaimRecord() {
    }

    public WarrantyClaimRecord(String serialNumber, String claimantName, String claimReason) {
        this.serialNumber = serialNumber;
        this.claimantName = claimantName;
        this.claimReason = claimReason;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.submittedAt = LocalDateTime.now();
        if (status == null) status = "PENDING";
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getSerialNumber() { return serialNumber; }

    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getClaimantName() { return claimantName; }

    public void setClaimantName(String claimantName) { this.claimantName = claimantName; }

    public String getClaimantEmail() { return claimantEmail; }

    public void setClaimantEmail(String claimantEmail) { this.claimantEmail = claimantEmail; }

    public String getClaimReason() { return claimReason; }

    public void setClaimReason(String claimReason) { this.claimReason = claimReason; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public DeviceOwnershipRecord getDevice() { return device; }

    public void setDevice(DeviceOwnershipRecord device) { this.device = device; }

    public List<FraudAlertRecord> getFraudAlerts() { return fraudAlerts; }
}
