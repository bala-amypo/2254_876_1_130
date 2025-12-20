package com.example.entity;

import jakarta.persistence.*;

@Entity
public class WarrantyClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String claimReason;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_ownership_id")
    private DeviceOwnershipRecord deviceOwnershipRecord;

    // ===== GETTERS & SETTERS =====

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
