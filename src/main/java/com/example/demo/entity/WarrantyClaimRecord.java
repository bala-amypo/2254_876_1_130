package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false, updatable = false)
    private LocalDateTime submittedAt;

    @Column(nullable = false)
    private String status = "PENDING";

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceOwnershipRecord device;

    @JsonIgnore
    @OneToMany(mappedBy = "claim", cascade = CascadeType.ALL)
    private List<FraudAlertRecord> alerts = new ArrayList<>();

    // --- Constructors ---

    public WarrantyClaimRecord() {
        // Default constructor required by JPA
    }

    public WarrantyClaimRecord(Long id, String serialNumber, String claimantName, String claimantEmail,
                               String claimReason, LocalDateTime submittedAt, String status,
                               LocalDateTime createdAt, DeviceOwnershipRecord device, List<FraudAlertRecord> alerts) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.claimantName = claimantName;
        this.claimantEmail = claimantEmail;
        this.claimReaso
