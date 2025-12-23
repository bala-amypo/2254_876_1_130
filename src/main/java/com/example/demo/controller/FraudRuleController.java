package com.example.demo.controller;

import com.example.demo.model.FraudRuleRecord;
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
    public FraudRuleRecord create(@RequestBody FraudRuleRecord record) {
        return service.create(record);
    }

    @GetMapping
    public List<FraudRuleRecord> getAll() {
        return service.getAll();
    }
}
