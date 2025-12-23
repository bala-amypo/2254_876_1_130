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

    private final FraudAlertService fraudAlertService;

    @Autowired
    public FraudAlertController(FraudAlertService fraudAlertService) {
        this.fraudAlertService = fraudAlertService;
    }

    @PostMapping
    public ResponseEntity<FraudAlertRecord> createAlert(@RequestBody FraudAlertRecord alert) {
        FraudAlertRecord savedAlert = fraudAlertService.createAlert(alert);
        return ResponseEntity.ok(savedAlert);
    }

    @GetMapping
    public ResponseEntity<List<FraudAlertRecord>> getAllAlerts() {
        List<FraudAlertRecord> alerts = fraudAlertService.getAllAlerts();
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudAlertRecord> getAlertById(@PathVariable Long id) {
        FraudAlertRecord alert = fraudAlertService.getAlertById(id);
        if (alert == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alert);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        fraudAlertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }
}
