package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "device_ownership_records")
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private LocalDate warrantyExpiration;

    // Constructors, getters, setters
    public DeviceOwnershipRecord() {}
    public DeviceOwnershipRecord(String serialNumber, LocalDate warrantyExpiration) {
        this.serialNumber = serialNumber;
        this.warrantyExpiration = warrantyExpiration;
    }

    public String getSerialNumber() { return serialNumber; }
    public LocalDate getWarrantyExpiration() { return warrantyExpiration; }
}
