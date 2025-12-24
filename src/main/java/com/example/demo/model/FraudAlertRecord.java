package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String serialNumber;
    private Long claimId;
    private String alertType;
    private String description;
    private Boolean resolved = false;
    private LocalDateTime alertDate;
    
    public FraudAlertRecord() {}
    
    public static FraudAlertRecordBuilder builder() {
        return new FraudAlertRecordBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    
    public Long getClaimId() { return claimId; }
    public void setClaimId(Long claimId) { this.claimId = claimId; }
    
    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    
    public LocalDateTime getAlertDate() { return alertDate; }
    public void setAlertDate(LocalDateTime alertDate) { this.alertDate = alertDate; }
    
    public static class FraudAlertRecordBuilder {
        private FraudAlertRecord alert = new FraudAlertRecord();
        
        public FraudAlertRecordBuilder id(Long id) { alert.setId(id); return this; }
        public FraudAlertRecordBuilder serialNumber(String serialNumber) { alert.setSerialNumber(serialNumber); return this; }
        public FraudAlertRecordBuilder claimId(Long claimId) { alert.setClaimId(claimId); return this; }
        public FraudAlertRecordBuilder alertType(String alertType) { alert.setAlertType(alertType); return this; }
        public FraudAlertRecordBuilder description(String description) { alert.setDescription(description); return this; }
        public FraudAlertRecordBuilder resolved(Boolean resolved) { alert.setResolved(resolved); return this; }
        public FraudAlertRecordBuilder alertDate(LocalDateTime alertDate) { alert.setAlertDate(alertDate); return this; }
        
        public FraudAlertRecord build() { return alert; }
    }
}