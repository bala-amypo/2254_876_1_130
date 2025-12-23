package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alerts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alertMessage;

    private Boolean resolved = false;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (resolved == null) resolved = false;
        createdAt = LocalDateTime.now();
    }
}
