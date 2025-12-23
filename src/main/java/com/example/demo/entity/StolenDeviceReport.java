package com.example.demo.model;

import java.time.LocalDateTime;

public class StolenDeviceReport {
    private Long id;
    private String serialNumber;
    private LocalDateTime reportDate;

    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public LocalDateTime getReportDate() { return reportDate; }

    public void setId(Long id) { this.id = id; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public void setReportDate(LocalDateTime reportDate) { this.reportDate = reportDate; }
}
