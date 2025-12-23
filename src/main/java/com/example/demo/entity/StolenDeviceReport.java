package com.example.demo.model;

import java.time.LocalDateTime;

public class StolenDeviceReport {
    private Long id;
    private String deviceSerial;
    private LocalDateTime reportDate;

    public void setId(Long id) { this.id = id; }
    public void setDeviceSerial(String deviceSerial) { this.deviceSerial = deviceSerial; }
    public void setReportDate(LocalDateTime reportDate) { this.reportDate = reportDate; }
}
