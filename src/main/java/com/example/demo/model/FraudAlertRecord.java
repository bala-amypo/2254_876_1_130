package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String alertReason;

    @Column(nullable = false)
    private boolean resolved = false;   // ✅ Add this field

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAlertReason() { return alertReason; }
    public void setAlertReason(String alertReason) { this.alertReason = alertReason; }

    public boolean isResolved() { return resolved; }     // getter
    public void setResolved(boolean resolved) {         // setter
        this.resolved = resolved;
    }
}
