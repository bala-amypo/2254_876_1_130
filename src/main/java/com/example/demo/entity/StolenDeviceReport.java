package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String reporterName;

    @Column(nullable = false)
    private LocalDateTime reportedAt;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceOwnershipRecord deviceOwnershipRecord;

    @PrePersist
    public void prePersist() {
        this.reportedAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public String getReporterName() { return reporterName; }
    public void setReporterName(String reporterName) { this.reporterName = reporterName; }
    public LocalDateTime getReportedAt() { return reportedAt; }
    public DeviceOwnershipRecord getDeviceOwnershipRecord() { return deviceOwnershipRecord; }
    public void setDeviceOwnershipRecord(DeviceOwnershipRecord deviceOwnershipRecord) {
        this.deviceOwnershipRecord = deviceOwnershipRecord;
    }
}
