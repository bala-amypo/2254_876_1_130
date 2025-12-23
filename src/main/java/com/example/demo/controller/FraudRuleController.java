package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// Correct imports
import com.example.demo.entity.FraudRuleRecord;
import com.example.demo.service.FraudRuleService;

@RestController
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @GetMapping("/fraudRules")
    public List<FraudRuleRecord> getAllFraudRules() {
        // Correct method call
        return service.getAllFraudRules();
    }
}
