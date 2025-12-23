package com.example.demo.controller;

import com.example.demo.entity.FraudRuleRecord;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService fraudRuleService;

    public FraudRuleController(FraudRuleService fraudRuleService) {
        this.fraudRuleService = fraudRuleService;
    }

    @PostMapping
    public FraudRuleRecord create(@RequestBody FraudRuleRecord rule) {
        return fraudRuleService.createRule(rule);
    }

    @GetMapping
    public List<FraudRuleRecord> getAll() {
        return fraudRuleService.getAllRules();
    }
}
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_rules")
public class FraudRuleRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String condition;
    private boolean active;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
