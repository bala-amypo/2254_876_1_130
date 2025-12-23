package com.example.demo.model;
import lombok.Builder;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "device_ownership_records")
@Builder
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

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<WarrantyClaimRecord> claims = new ArrayList<>();

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<StolenDeviceReport> stolenReports = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        if (active == null) active = true;
    }
}
