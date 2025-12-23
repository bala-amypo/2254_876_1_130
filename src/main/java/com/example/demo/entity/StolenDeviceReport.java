package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports", uniqueConstraints = {
        @UniqueConstraint(columnNames = "serialNumber")
})
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String reportedBy;

    private String details;

    @Column(nullable = false, updatable = false)
    private LocalDateTime reportDate;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceOwnershipRecord device;

    public StolenDeviceReport() {
    }

    public StolenDeviceReport(String serialNumber, String reportedBy) {
        this.serialNumber = serialNumber;
        this.reportedBy = reportedBy;
    }

    @PrePersist
    protected void onCreate() {
        this.reportDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public DeviceOwnershipRecord getDevice() {
        return device;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDevice(DeviceOwnershipRecord device) {
        this.device = device;
    }
}
