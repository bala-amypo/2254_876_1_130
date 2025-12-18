package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "device_ownership_records")
@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "deviceOwnershipRecord")
    private List<WarrantyClaimRecord> claims;

    @OneToMany(mappedBy = "deviceOwnershipRecord")
    private List<StolenDeviceReport> stolenReports;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (active == null) active = true;
    }
}
