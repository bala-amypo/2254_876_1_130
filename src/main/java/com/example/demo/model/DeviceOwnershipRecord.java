package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "device_ownership_records",
    uniqueConstraints = @UniqueConstraint(columnNames = "serialNumber")
)
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String ownerName;

    private String ownerEmail;

    private LocalDate purchaseDate;

    @Column(nullable = false)
    private LocalDate warrantyExpiration;

    private Boolean active = true;

    private LocalDateTime createdAt;

    public DeviceOwnershipRecord() {
    }

    public DeviceOwnershipRecord(
            String serialNumber,
            String ownerName,
            LocalDate warrantyExpiration
    ) {
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.warrantyExpiration = warrantyExpiration;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
