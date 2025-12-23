package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceSerialNumber;
    private String description;
    private boolean resolved;

    // Constructors
    public FraudAlertRecord() {}

    public FraudAlertRecord(String deviceSerialNumber, String description, boolean resolved) {
        this.deviceSerialNumber = deviceSerialNumber;
        this.description = description;
        this.resolved = resolved;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeviceSerialNumber() { return deviceSerialNumber; }
    public void setDeviceSerialNumber(String deviceSerialNumber) { this.deviceSerialNumber = deviceSerialNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
