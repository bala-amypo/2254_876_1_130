package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @Column(nullable = false)
    private Boolean active = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private Set<WarrantyClaimRecord> warrantyClaims = new HashSet<>();

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private Set<StolenDeviceReport> stolenReports = new HashSet<>();

    @PrePersist
    private void prePersist() {
        if (active == null) active = true;
    }

    public DeviceOwnershipRecord(String serialNumber, String ownerName, String ownerEmail,
                                 LocalDate purchaseDate, LocalDate warrantyExpiration, Boolean active) {
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.purchaseDate = purchaseDate;
        this.warrantyExpiration = warrantyExpiration;
        this.active = active != null ? active : true;
    }
}
