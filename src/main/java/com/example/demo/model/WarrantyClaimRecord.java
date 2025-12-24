package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String serialNumber;
    private String claimReason;
    private String status = "PENDING";
    private LocalDateTime claimDate;
    
    public WarrantyClaimRecord() {}
    
    public static WarrantyClaimRecordBuilder builder() {
        return new WarrantyClaimRecordBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    
    public String getClaimReason() { return claimReason; }
    public void setClaimReason(String claimReason) { this.claimReason = claimReason; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getClaimDate() { return claimDate; }
    public void setClaimDate(LocalDateTime claimDate) { this.claimDate = claimDate; }
    
    public static class WarrantyClaimRecordBuilder {
        private WarrantyClaimRecord record = new WarrantyClaimRecord();
        
        public WarrantyClaimRecordBuilder id(Long id) { record.setId(id); return this; }
        public WarrantyClaimRecordBuilder serialNumber(String serialNumber) { record.setSerialNumber(serialNumber); return this; }
        public WarrantyClaimRecordBuilder claimReason(String claimReason) { record.setClaimReason(claimReason); return this; }
        public WarrantyClaimRecordBuilder status(String status) { record.setStatus(status); return this; }
        public WarrantyClaimRecordBuilder claimDate(LocalDateTime claimDate) { record.setClaimDate(claimDate); return this; }
        
        public WarrantyClaimRecord build() { return record; }
    }
}