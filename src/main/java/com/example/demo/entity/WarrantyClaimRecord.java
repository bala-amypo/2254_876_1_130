package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private String claimReason;

    private String status; // PENDING, FLAGGED, APPROVED, REJECTED

    @ManyToOne
    private DeviceOwnershipRecord deviceOwnershipRecord;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DeviceOwnershipRecord getDeviceOwnershipRecord() {
        return deviceOwnershipRecord;
    }

    public void setDeviceOwnershipRecord(DeviceOwnershipRecord deviceOwnershipRecord) {
        this.deviceOwnershipRecord = deviceOwnershipRecord;
    }
}
