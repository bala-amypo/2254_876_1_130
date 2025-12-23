package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "device_ownerships")
public class DeviceOwnership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;
    private String deviceSerialNumber;
    private boolean stolen = false;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getDeviceSerialNumber() { return deviceSerialNumber; }
    public void setDeviceSerialNumber(String deviceSerialNumber) { this.deviceSerialNumber = deviceSerialNumber; }

    public boolean isStolen() { return stolen; }
    public void setStolen(boolean stolen) { this.stolen = stolen; }
}
