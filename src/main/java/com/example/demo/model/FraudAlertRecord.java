package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_alerts")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceSerialNumber;
    private String alertMessage;

    public FraudAlertRecord() {}

    public FraudAlertRecord(String deviceSerialNumber, String alertMessage) {
        this.deviceSerialNumber = deviceSerialNumber;
        this.alertMessage = alertMessage;
    }

    public Long getId() {
        return id;
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }
}
