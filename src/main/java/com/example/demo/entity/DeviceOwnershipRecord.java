package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "device_ownership_records")
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String ownerName;

    @Column
    private String ownerEmail;

    private LocalDate purchaseDate;

    @Column(nullable = false)
    private LocalDate warrantyExpiration;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "deviceOwnershipRecord",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<WarrantyClaimRecord> claims = new ArrayList<>();

    @OneToMany(mappedBy = "deviceOwnershipRecord",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<StolenDeviceReport> stolenReports = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== GETTERS & SETTERS (FIX) =====

    public Long getId() {
        return id;
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

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<WarrantyClaimRecord> getClaims() {
        return claims;
    }

    public List<StolenDeviceReport> getStolenReports() {
        return stolenReports;
    }
}
