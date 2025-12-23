package com.example.demo.controller;

import com.example.demo.entity.FraudRuleRecord;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping
    public FraudRuleRecord create(@RequestBody FraudRuleRecord rule) {
        return service.save(rule);
    }

    @GetMapping
    public List<FraudRuleRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FraudRuleRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
