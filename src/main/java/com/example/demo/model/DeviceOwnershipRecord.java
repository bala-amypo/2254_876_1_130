package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceSerialNumber;
    private String ownerName;
    private boolean active;

    public DeviceOwnershipRecord() {}

    public DeviceOwnershipRecord(String deviceSerialNumber, String ownerName, boolean active) {
        this.deviceSerialNumber = deviceSerialNumber;
        this.ownerName = ownerName;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeviceSerialNumber() { return deviceSerialNumber; }
    public void setDeviceSerialNumber(String deviceSerialNumber) { this.deviceSerialNumber = deviceSerialNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
