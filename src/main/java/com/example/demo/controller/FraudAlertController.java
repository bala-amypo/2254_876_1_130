package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;

@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FraudAlertRecord> createAlert(
            @RequestBody FraudAlertRecord alert) {

        return ResponseEntity.ok(service.createAlert(alert));
    }

    @GetMapping
    public ResponseEntity<List<FraudAlertRecord>> getAllAlerts() {
        return ResponseEntity.ok(service.getAllAlerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudAlertRecord> getAlertById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getAllAlerts()
                        .stream()
                        .filter(a -> a.getId().equals(id))
                        .findFirst()
                        .orElseThrow()
        );
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<FraudAlertRecord>> getAlertsBySerial(
            @PathVariable String serialNumber) {

        return ResponseEntity.ok(
                service.getAlertsBySerial(serialNumber));
    }

    @GetMapping("/claim/{claimId}")
    public ResponseEntity<List<FraudAlertRecord>> getAlertsByClaim(
            @PathVariable Long claimId) {

        return ResponseEntity.ok(
                service.getAlertsByClaim(claimId));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<FraudAlertRecord> resolveAlert(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.resolveAlert(id));
    }
}
