package com.example.demo.controller;

/* ===== IMPORTS ===== */
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

    @PostMapping
    public ResponseEntity<FraudRule> create(@RequestBody FraudRule rule) {
        return ResponseEntity.ok(fraudRuleService.createRule(rule));
    }

    @GetMapping
    public ResponseEntity<List<FraudRule>> getAll() {
        return ResponseEntity.ok(fraudRuleService.getAllRules());
    }

    @GetMapping("/active")
    public ResponseEntity<List<FraudRule>> getActive() {
        return ResponseEntity.ok(fraudRuleService.getActiveRules());
    }
}
