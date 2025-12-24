package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ MUST be named serialNumber (per test helper)
    @Column(unique = true, nullable = false)
    private String serialNumber;

    private String reportedBy;

    private String details;

    private LocalDateTime reportDate;

    @PrePersist
    public void onCreate() {
        this.reportDate = LocalDateTime.now();
    }
}
