package com.example.demo.controller;

import com.example.demo.model.FraudAlert;
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

    // Create a fraud alert (ADMIN only)
    @PostMapping
    public ResponseEntity<FraudAlert> createAlert(@RequestBody FraudAlert alert) {
        FraudAlert savedAlert = fraudAlertService.createAlert(alert);
        return ResponseEntity.ok(savedAlert);
    }

    // Get all alerts
    @GetMapping
    public ResponseEntity<List<FraudAlert>> getAllAlerts() {
        return ResponseEntity.ok(fraudAlertService.getAllAlerts());
    }

    // Get alert by ID
    @GetMapping("/{id}")
    public ResponseEntity<FraudAlert> getAlertById(@PathVariable Long id) {
        return fraudAlertService.getAlertById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    // Get alerts by device serial number
    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<FraudAlert>> getAlertsBySerial(@PathVariable String serialNumber) {
        return ResponseEntity.ok(fraudAlertService.getAlertsBySerial(serialNumber));
    }

    // Get alerts by claim ID
    @GetMapping("/claim/{claimId}")
    public ResponseEntity<List<FraudAlert>> getAlertsByClaim(@PathVariable Long claimId) {
        return ResponseEntity.ok(fraudAlertService.getAlertsByClaim(claimId));
    }

    // Resolve alert (ADMIN only)
    @PutMapping("/{id}/resolve")
    public ResponseEntity<FraudAlert> resolveAlert(@PathVariable Long id) {
        FraudAlert resolved = fraudAlertService.resolveAlert(id);
        return ResponseEntity.ok(resolved);
    }
}
