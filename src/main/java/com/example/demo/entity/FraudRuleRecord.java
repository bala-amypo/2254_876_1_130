package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_rules")
public class FraudRuleRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String description;
    private boolean active;

    public FraudRuleRecord() {}

    public FraudRuleRecord(String ruleName, String description, boolean active) {
        this.ruleName = ruleName;
        this.description = description;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
