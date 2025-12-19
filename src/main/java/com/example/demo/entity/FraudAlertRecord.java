package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "claim_id", nullable = false)
    private WarrantyClaimRecord warrantyClaimRecord;

    @Column(nullable = false)
    private String alertReason;

    public FraudAlertRecord() {}
    public FraudAlertRecord(WarrantyClaimRecord claim, String reason) {
        this.warrantyClaimRecord = claim;
        this.alertReason = reason;
    }
}
