package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
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
    private String status = "PENDING";

    @Column(nullable = false, updatable = false)
    private LocalDateTime submittedAt;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceOwnershipRecord deviceOwnershipRecord;

    @OneToMany(mappedBy = "warrantyClaimRecord")
    private List<FraudAlertRecord> fraudAlerts;

    public WarrantyClaimRecord() {}

    public WarrantyClaimRecord(
            String serialNumber,
            String claimantName,
            String claimantEmail,
            String claimReason
    ) {
        this.serialNumber = serialNumber;
        this.claimantName = claimantName;
        this.claimantEmail = claimantEmail;
        this.claimReason = claimReason;
    }

    @PrePersist
    protected void onCreate() {
        this.submittedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters (only key ones shown)

    public Long getId() { return id; }

    public String getSerialNumber() { return serialNumber; }

    public String getClaimReason() { return claimReason; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public void setDeviceOwnershipRecord(DeviceOwnershipRecord deviceOwnershipRecord) {
        this.deviceOwnershipRecord = deviceOwnershipRecord;
    }
}
