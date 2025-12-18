package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
@Getter
@Setter
@NoArgsConstructor
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String reportedBy;

    @CreationTimestamp
    private LocalDateTime reportDate;

    private String details;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceOwnershipRecord device;

    public StolenDeviceReport(String serialNumber, String reportedBy, String details) {
        this.serialNumber = serialNumber;
        this.reportedBy = reportedBy;
        this.details = details;
    }
}
