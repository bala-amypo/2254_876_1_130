package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String reportedBy;

    @Column(nullable = false)
    private LocalDateTime reportDate;

    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private DeviceOwnershipRecord device;

    public StolenDeviceReport() {
    }

    public StolenDeviceReport(String serialNumber, String reportedBy, String details) {
        this.serialNumber = serialNumber;
        this.reportedBy = reportedBy;
        this.details = details;
    }

    @PrePersist
    protected void onCreate() {
        this.reportDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public String getReportedBy() { return reportedBy; }
    public void setReportedBy(String reportedBy) { this.reportedBy = reportedBy; }
    public LocalDateTime getReportDate() { return reportDate; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public DeviceOwnershipRecord getDevice() { return device; }
    public void setDevice(DeviceOwnershipRecord device) { this.device = device; }
}
