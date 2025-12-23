package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "device_ownership_records")
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;

    private String serialNumber;

    private boolean active;

    private LocalDateTime warrantyExpiration;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "device_ownership_id")
    private Set<WarrantyClaimRecord> claims;

    // Constructors
    public DeviceOwnershipRecord() {}

    public DeviceOwnershipRecord(String ownerName, String serialNumber, boolean active, LocalDateTime warrantyExpiration) {
        this.ownerName = ownerName;
        this.serialNumber = serialNumber;
        this.active = active;
        this.warrantyExpiration = warrantyExpiration;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getWarrantyExpiration() { return warrantyExpiration; }
    public void setWarrantyExpiration(LocalDateTime warrantyExpiration) { this.warrantyExpiration = warrantyExpiration; }

    public Set<WarrantyClaimRecord> getClaims() { return claims; }
    public void setClaims(Set<WarrantyClaimRecord> claims) { this.claims = claims; }
}
