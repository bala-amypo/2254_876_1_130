package com.example.demo.entity;

import com.example.demo.model.DeviceOwnershipRecord;
import jakarta.persistence.*;

@Entity
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimNumber;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceOwnershipRecord deviceOwnershipRecord;

    private String description;
    private boolean approved;

    public WarrantyClaimRecord() {}

    public WarrantyClaimRecord(String claimNumber, DeviceOwnershipRecord deviceOwnershipRecord, String description, boolean approved) {
        this.claimNumber = claimNumber;
        this.deviceOwnershipRecord = deviceOwnershipRecord;
        this.description = description;
        this.approved = approved;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClaimNumber() { return claimNumber; }
    public void setClaimNumber(String claimNumber) { this.claimNumber = claimNumber; }

    public DeviceOwnershipRecord getDeviceOwnershipRecord() { return deviceOwnershipRecord; }
    public void setDeviceOwnershipRecord(DeviceOwnershipRecord deviceOwnershipRecord) { this.deviceOwnershipRecord = deviceOwnershipRecord; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
}
