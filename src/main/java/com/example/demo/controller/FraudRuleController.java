package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService fraudRuleService;

    public FraudRuleController(FraudRuleService fraudRuleService) {
        this.fraudRuleService = fraudRuleService;
    }

    // Create new fraud rule (ADMIN only)
    @PostMapping
    public ResponseEntity<FraudRule> createRule(@RequestBody FraudRule rule) {
        FraudRule savedRule = fraudRuleService.createRule(rule);
        return ResponseEntity.ok(savedRule);
    }

    // List all rules
    @GetMapping
    public ResponseEntity<List<FraudRule>> getAllRules() {
        return ResponseEntity.ok(fraudRuleService.getAllRules());
    }

    // Get rule by ID
    @GetMapping("/{id}")
    public ResponseEntity<FraudRule> getRuleById(@PathVariable Long id) {
        return fraudRuleService.getAllRules().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    // Get active rules
    @GetMapping("/active")
    public ResponseEntity<List<FraudRule>> getActiveRules() {
        return ResponseEntity.ok(fraudRuleService.getActiveRules());
    }

    // Update rule (ADMIN only)
    @PutMapping("/{id}")
    public ResponseEntity<FraudRule> updateRule(
            @PathVariable Long id,
            @RequestBody FraudRule rule) {

        FraudRule updated = fraudRuleService.updateRule(id, rule);
        return ResponseEntity.ok(updated);
    }
}
