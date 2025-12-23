package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertService fraudAlertService;

    public FraudAlertController(FraudAlertService fraudAlertService) {
        this.fraudAlertService = fraudAlertService;
    }

    @PostMapping
    public ResponseEntity<FraudAlertRecord> createAlert(@RequestBody FraudAlertRecord alert) {
        FraudAlertRecord created = fraudAlertService.createAlert(alert);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<FraudAlertRecord> resolveAlert(@PathVariable Long id) {
        FraudAlertRecord resolved = fraudAlertService.resolveAlert(id);
        return ResponseEntity.ok(resolved);
    }

    @GetMapping
    public ResponseEntity<List<FraudAlertRecord>> getAllAlerts() {
        List<FraudAlertRecord> alerts = fraudAlertService.getAllAlerts();
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<FraudAlertRecord>> getAlertsBySerial(@PathVariable String serialNumber) {
        List<FraudAlertRecord> alerts = fraudAlertService.getAlertsBySerial(serialNumber);
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/claim/{claimId}")
    public ResponseEntity<List<FraudAlertRecord>> getAlertsByClaim(@PathVariable Long claimId) {
        List<FraudAlertRecord> alerts = fraudAlertService.getAlertsByClaim(claimId);
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudAlertRecord> getAlertById(@PathVariable Long id) {
        return fraudAlertService.getAlertById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
