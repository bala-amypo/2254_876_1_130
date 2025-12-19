package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @OneToMany(mappedBy = "warrantyClaim", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FraudAlertRecord> fraudAlerts = new ArrayList<>();

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<FraudAlertRecord> getFraudAlerts() {
        return fraudAlerts;
    }

    public void setFraudAlerts(List<FraudAlertRecord> fraudAlerts) {
        this.fraudAlerts = fraudAlerts;
    }
}
