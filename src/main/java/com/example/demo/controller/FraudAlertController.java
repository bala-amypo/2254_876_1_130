package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {
    
    private final FraudAlertService service;
    
    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<FraudAlertRecord> createAlert(@RequestBody FraudAlertRecord alert) {
        return ResponseEntity.ok(service.create(alert));
    }
    
    @GetMapping
    public ResponseEntity<List<FraudAlertRecord>> getAllAlerts() {
        return ResponseEntity.ok(service.getAll());
    }
}
