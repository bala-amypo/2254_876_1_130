package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reportReason;

    @Column(nullable = false)
    private LocalDateTime reportedAt;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceOwnershipRecord deviceOwnershipRecord;

    @PrePersist
    protected void onCreate() {
        this.reportedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public DeviceOwnershipRecord getDeviceOwnershipRecord() {
        return deviceOwnershipRecord;
    }

    public void setDeviceOwnershipRecord(DeviceOwnershipRecord deviceOwnershipRecord) {
        this.deviceOwnershipRecord = deviceOwnershipRecord;
    }
}
