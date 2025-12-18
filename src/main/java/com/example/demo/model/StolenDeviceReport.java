package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String status; // "REPORTED" or "RESOLVED"

    @ManyToOne
    private DeviceOwnershipRecord device;

    public StolenDeviceReport() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public DeviceOwnershipRecord getDevice() { return device; }
    public void setDevice(DeviceOwnershipRecord device) { this.device = device; }
}
