package com.example.fraud.controller;

import com.example.fraud.entity.FraudRule;
import com.example.fraud.service.FraudRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    // ADMIN only
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FraudRule> createRule(@RequestBody FraudRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    // ADMIN only
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FraudRule> updateRule(
            @PathVariable Long id,
            @RequestBody FraudRule updatedRule
    ) {
        return ResponseEntity.ok(service.updateRule(id, updatedRule));
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<FraudRule>> getAllRules() {
        return ResponseEntity.ok(service.getAllRules());
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<FraudRule> getRuleById(@PathVariable Long id) {
        return service.getAllRules().stream()
                .filter(rule -> rule.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<FraudRule>> getActiveRules() {
        return ResponseEntity.ok(service.getActiveRules());
    }
}
