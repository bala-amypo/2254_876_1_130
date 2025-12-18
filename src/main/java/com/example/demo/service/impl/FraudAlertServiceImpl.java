package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraudAlertServiceImpl {

    private final FraudAlertRepository alertRepository;

    public FraudAlertServiceImpl(FraudAlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    // Get all alerts
    public List<FraudAlertRecord> getAllAlerts() {
        return alertRepository.findAll();
    }

    // Get alert by ID
    public Optional<FraudAlertRecord> getAlertById(Long id) {
        return alertRepository.findById(id);
    }

    // Resolve alert
    public void resolveAlert(Long id) {
        Optional<FraudAlertRecord> alertOpt = alertRepository.findById(id);
        alertOpt.ifPresent(alert -> {
            alert.setResolved(true);
            alertRepository.save(alert);
        });
    }

    // Save new alert
    public FraudAlertRecord saveAlert(FraudAlertRecord alert) {
        return alertRepository.save(alert);
    }
}
