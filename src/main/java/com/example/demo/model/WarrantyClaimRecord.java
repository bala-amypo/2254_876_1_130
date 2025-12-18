package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "warranty_claim_records")
@Getter
@Setter
@NoArgsConstructor
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

    @CreationTimestamp
    private LocalDateTime submittedAt;

    @Column(nullable = false)
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED, FLAGGED

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceOwnershipRecord device;

    @OneToMany(mappedBy = "warrantyClaim", cascade = CascadeType.ALL)
    private Set<FraudAlertRecord> fraudAlerts = new HashSet<>();

    public WarrantyClaimRecord(String serialNumber, String claimantName, String claimantEmail, String claimReason) {
        this.serialNumber = serialNumber;
        this.claimantName = claimantName;
        this.claimantEmail = claimantEmail;
        this.claimReason = claimReason;
        this.status = "PENDING";
    }
}
