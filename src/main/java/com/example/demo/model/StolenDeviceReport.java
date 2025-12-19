package com.example.demo.model;

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
    private String reportedBy;

    private String details;

    @Column(nullable = false)
    private LocalDateTime reportDate;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceOwnershipRecord device;

    public StolenDeviceReport() { }

    public StolenDeviceReport(String serialNumber, String reportedBy, String details, DeviceOwnershipRecord device) {
        this.serialNumber = serialNumber;
        this.reportedBy = reportedBy;
        this.details = details;
        this.device = device;
    }

    @PrePersist
    protected void onCreate() {
        this.reportDate = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public String getReportedBy() { return reportedBy; }
    public String getDetails() { return details; }
    public LocalDateTime getReportDate() { return reportDate; }
    public DeviceOwnershipRecord getDevice() { return device; }
}
