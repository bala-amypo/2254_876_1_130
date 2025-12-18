package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String ruleType;
    private String description;
    private boolean active;

    public FraudRule() {
    }

    public Long getId() {
        return id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public String getRuleType() {
        return ruleType;
    }

    public String getDescription() {
        return description;
    }

    public boolean getActive() {
        return active;
    }
}
