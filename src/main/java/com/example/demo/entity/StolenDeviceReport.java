package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false, updatable = false)
    private LocalDateTime reportDate;

    @ManyToOne
    @JoinColumn(name = "device_id")
    @JsonIgnore
    private DeviceOwnershipRecord device;

    // --- Constructors ---

    public StolenDeviceReport() {
        // Default constructor required by JPA
    }

    public StolenDeviceReport(Long id, String serialNumber, String reportedBy, String details,
                              LocalDateTime reportDate, DeviceOwnershipRecord device) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.reportedBy = reportedBy;
        this.details = details;
        this.reportDate = reportDate != null ? reportDate : LocalDateTime.now();
        this.device = device;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public DeviceOwnershipRecord getDevice() {
        return device;
    }

    public void setDevice(DeviceOwnershipRecord device) {
        this.device = device;
    }

    // --- JPA PrePersist ---

    @PrePersist
    public void prePersist() {
        if (reportDate == null) {
            reportDate = LocalDateTime.now();
        }
    }
}
