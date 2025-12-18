package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
@RequiredArgsConstructor
public class FraudAlertController {

    private final FraudAlertService alertService;

    @PostMapping
    public FraudAlertRecord create(@RequestBody FraudAlertRecord alert) {
        return alertService.create(alert);
    }

    @GetMapping
    public List<FraudAlertRecord> getAll() {
        return alertService.getAll();
    }

    @GetMapping("/{id}")
    public FraudAlertRecord getById(@PathVariable Long id) {
        return alertService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alertService.delete(id);
    }
}
