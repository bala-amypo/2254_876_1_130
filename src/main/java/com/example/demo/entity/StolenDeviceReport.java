package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String reportedBy;

    private String details;

    @Column(nullable = false, updatable = false)
    private LocalDateTime reportDate;

    @ManyToOne
    @JoinColumn(name = "device_id")
    @JsonIgnore
    private DeviceOwnershipRecord device;

    @PrePersist
    public void prePersist() {
        reportDate = LocalDateTime.now();
    }
}
