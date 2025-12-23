package com.example.demo.entity;

import com.example.demo.model.DeviceOwnership;
import jakarta.persistence.*;

@Entity
@Table(name = "warranty_claims")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceOwnership device;

    private String claimReason;
    private boolean approved;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public DeviceOwnership getDevice() { return device; }
    public void setDevice(DeviceOwnership device) { this.device = device; }

    public String getClaimReason() { return claimReason; }
    public void setClaimReason(String claimReason) { this.claimReason = claimReason; }

    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
}
