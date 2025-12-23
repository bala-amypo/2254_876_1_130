package com.example.demo.controller;

import com.example.demo.entity.FraudRuleRecord;
import com.example.demo.service.FraudRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fraud-rules")
public class FraudRuleController {

    @Autowired
    private FraudRuleService service;

    @PostMapping
    public FraudRuleRecord create(@RequestBody FraudRuleRecord record) {
        return service.create(record);
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
