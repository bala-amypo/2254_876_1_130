package com.example.demo.controller;

import com.example.demo.entity.FraudRuleRecord;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @GetMapping
    public List<FraudRuleRecord> getAll() {
        return service.getAll();
    }

    @PostMapping
    public FraudRuleRecord create(@RequestBody FraudRuleRecord record) {
        return service.save(record);
    }
}
