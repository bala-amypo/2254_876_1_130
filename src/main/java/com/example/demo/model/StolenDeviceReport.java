package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String serialNumber;
    private LocalDateTime reportDate;
    private String reporterName;
    private String reporterContact;
    
    public StolenDeviceReport() {}
    
    public static StolenDeviceReportBuilder builder() {
        return new StolenDeviceReportBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    
    public LocalDateTime getReportDate() { return reportDate; }
    public void setReportDate(LocalDateTime reportDate) { this.reportDate = reportDate; }
    
    public String getReporterName() { return reporterName; }
    public void setReporterName(String reporterName) { this.reporterName = reporterName; }
    
    public String getReporterContact() { return reporterContact; }
    public void setReporterContact(String reporterContact) { this.reporterContact = reporterContact; }
    
    public static class StolenDeviceReportBuilder {
        private StolenDeviceReport report = new StolenDeviceReport();
        
        public StolenDeviceReportBuilder id(Long id) { report.setId(id); return this; }
        public StolenDeviceReportBuilder serialNumber(String serialNumber) { report.setSerialNumber(serialNumber); return this; }
        public StolenDeviceReportBuilder reportDate(LocalDateTime reportDate) { report.setReportDate(reportDate); return this; }
        public StolenDeviceReportBuilder reporterName(String reporterName) { report.setReporterName(reporterName); return this; }
        public StolenDeviceReportBuilder reporterContact(String reporterContact) { report.setReporterContact(reporterContact); return this; }
        
        public StolenDeviceReport build() { return report; }
    }
}