package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alertDetails;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public FraudAlertRecord() {
    }

    public FraudAlertRecord(String alertDetails, User user) {
        this.alertDetails = alertDetails;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getAlertDetails() {
        return alertDetails;
    }

    public void setAlertDetails(String alertDetails) {
        this.alertDetails = alertDetails;
    }

    public User getUser() {
        return user;
    }
}
