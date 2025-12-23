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
