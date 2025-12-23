package com.example.demo.controller;

import com.example.demo.model.FraudAlert;
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
    public ResponseEntity<FraudAlert> createAlert(@RequestBody FraudAlert alert) {
        return ResponseEntity.ok(fraudAlertService.createAlert(alert));
    }

    @GetMapping
    public ResponseEntity<List<FraudAlert>> getAllAlerts() {
        return ResponseEntity.ok(fraudAlertService.getAllAlerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudAlert> getAlertById(@PathVariable Long id) {
        return ResponseEntity.ok(fraudAlertService.getAlertById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        fraudAlertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }
}
