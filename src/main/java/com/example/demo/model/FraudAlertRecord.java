package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;
    private String alertReason;
    private boolean resolved;

    public FraudAlertRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
