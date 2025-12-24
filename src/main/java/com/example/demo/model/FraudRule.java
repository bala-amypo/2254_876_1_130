package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_rules")
public class FraudRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String ruleCode;
    
    private String ruleType;
    private String description;
    private Boolean active = true;
    
    public FraudRule() {}
    
    public static FraudRuleBuilder builder() {
        return new FraudRuleBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    
    public String getRuleType() { return ruleType; }
    public void setRuleType(String ruleType) { this.ruleType = ruleType; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    
    public static class FraudRuleBuilder {
        private FraudRule rule = new FraudRule();
        
        public FraudRuleBuilder id(Long id) { rule.setId(id); return this; }
        public FraudRuleBuilder ruleCode(String ruleCode) { rule.setRuleCode(ruleCode); return this; }
        public FraudRuleBuilder ruleType(String ruleType) { rule.setRuleType(ruleType); return this; }
        public FraudRuleBuilder description(String description) { rule.setDescription(description); return this; }
        public FraudRuleBuilder active(Boolean active) { rule.setActive(active); return this; }
        
        public FraudRule build() { return rule; }
    }
}