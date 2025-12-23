package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_ownerships")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceSerial;

    private String ownerName;

    @Builder.Default
    private LocalDateTime purchaseDate = LocalDateTime.now();

    @Builder.Default
    private boolean verified = false;
}
