
package com.example.demo.controller;

import com.example.demo.entity.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FraudRule> createRule(@RequestBody FraudRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FraudRule> updateRule(
            @PathVariable Long id,
            @RequestBody FraudRule updatedRule
    ) {
        return ResponseEntity.ok(service.updateRule(id, updatedRule));
    }

    @GetMapping
    public ResponseEntity<List<FraudRule>> getAllRules() {
        return ResponseEntity.ok(service.getAllRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudRule> getRuleById(@PathVariable Long id) {
        return service.getAllRules().stream()
                .filter(rule -> rule.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    public ResponseEntity<List<FraudRule>> getActiveRules() {
        return ResponseEntity.ok(service.getActiveRules());
    }
}
