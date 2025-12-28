package com.example.demo.model;

import jakarta.persistence.*; // time related persistnce and jakarta for  importing lib
import java.time.LocalDate;

@Entity
@Table(name = "device_ownership_records")
public class DeviceOwnershipRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String serialNumber;
    
    private String ownerName;
    private String ownerEmail;
    private LocalDate warrantyExpiration;
    private Boolean active;
    
    public DeviceOwnershipRecord() {}
    
    public static DeviceOwnershipRecordBuilder builder() {
        return new DeviceOwnershipRecordBuilder();
    }
    
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
    
    public String getOwnerName() {
         return ownerName;
          }
    public void setOwnerName(String ownerName) {
        
     this.ownerName = ownerName; 
     }
    
    public String getOwnerEmail() {
         return ownerEmail;
          }
    public void setOwnerEmail(String ownerEmail) {
         this.ownerEmail = ownerEmail;
          }
    
    public LocalDate getWarrantyExpiration() {
        
     return warrantyExpiration;
      }
    public void setWarrantyExpiration(LocalDate warrantyExpiration)
     {
         this.warrantyExpiration = warrantyExpiration; 
         }
    
    public Boolean getActive() {
        
     return active; 
     }
    public void setActive(Boolean active) {
         this.active = active;
          }
    
    public static class DeviceOwnershipRecordBuilder {
        private DeviceOwnershipRecord record = new DeviceOwnershipRecord();
        
        public DeviceOwnershipRecordBuilder id(Long id) { 
            record.setId(id); return this;
             }
        public DeviceOwnershipRecordBuilder serialNumber(String serialNumber) {
            
         record.setSerialNumber(serialNumber); return this;
          }
        public DeviceOwnershipRecordBuilder ownerName(String ownerName) { 
            record.setOwnerName(ownerName); return this;
             }
        public DeviceOwnershipRecordBuilder ownerEmail(String ownerEmail) {
             record.setOwnerEmail(ownerEmail); return this;
              }
        public DeviceOwnershipRecordBuilder warrantyExpiration(LocalDate warrantyExpiration) { 
            record.setWarrantyExpiration(warrantyExpiration); return this;
             }
        public DeviceOwnershipRecordBuilder active(Boolean active) {
             record.setActive(active); return this;
              }
        
        public DeviceOwnershipRecord build() {
             return record; }
    }
}