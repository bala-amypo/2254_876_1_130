package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String claimReason;
    private String status;

    @ManyToOne
    private DeviceOwnershipRecord device;

    private LocalDateTime submittedAt;

    public WarrantyClaimRecord() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDevice(DeviceOwnershipRecord device) {
        this.device = device;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
