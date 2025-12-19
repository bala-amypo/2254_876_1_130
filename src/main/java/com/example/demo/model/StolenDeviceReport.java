package com.example.demo.model;   // ✅ MUST MATCH FOLDER

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceOwnershipRecord device;

    private LocalDateTime reportedAt;

    public StolenDeviceReport() {}

    @PrePersist
    protected void onCreate() {
        this.reportedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public DeviceOwnershipRecord getDevice() { return device; }
    public void setDevice(DeviceOwnershipRecord device) { this.device = device; }

    public LocalDateTime getReportedAt() { return reportedAt; }
}
