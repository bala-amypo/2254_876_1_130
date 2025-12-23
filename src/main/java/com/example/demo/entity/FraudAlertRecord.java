package com.example.demo.model;

import java.time.LocalDateTime;

public class FraudAlertRecord {
    private Long id;
    private String serialNumber;
    private LocalDateTime alertDate;
    private boolean resolved;

    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public LocalDateTime getAlertDate() { return alertDate; }
    public boolean isResolved() { return resolved; }

    public void setId(Long id) { this.id = id; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public void setAlertDate(LocalDateTime alertDate) { this.alertDate = alertDate; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
