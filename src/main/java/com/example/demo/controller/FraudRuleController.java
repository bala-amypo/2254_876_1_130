package com.example.demo.controller;

import com.example.demo.model.FraudRuleRecord;
import com.example.demo.service.FraudRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    @Autowired
    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FraudRuleRecord> createRule(@RequestBody FraudRuleRecord rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    @GetMapping
    public ResponseEntity<List<FraudRuleRecord>> getAllRules() {
        return ResponseEntity.ok(service.getAllRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudRuleRecord> getRule(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRuleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        service.deleteRule(id);
        return ResponseEntity.ok().build();
    }
}
