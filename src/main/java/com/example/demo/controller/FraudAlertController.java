package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    @Autowired
    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FraudAlertRecord> createAlert(@RequestBody FraudAlertRecord alert) {
        return ResponseEntity.ok(service.createAlert(alert));
    }

    @GetMapping
    public ResponseEntity<List<FraudAlertRecord>> getAllAlerts() {
        return ResponseEntity.ok(service.getAllAlerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudAlertRecord> getAlert(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAlertById(id));
    }

    @PutMapping("/resolve/{id}")
    public ResponseEntity<Void> resolveAlert(@PathVariable Long id) {
        service.resolveAlert(id);
        return ResponseEntity.ok().build();
    }
}
