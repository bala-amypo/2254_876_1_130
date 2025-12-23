package com.example.demo.service.impl;

import com.example.demo.model.FraudAlert;
import com.example.demo.repository.FraudAlertRepository;
import com.example.demo.service.FraudAlertService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository fraudAlertRepository;

    public FraudAlertServiceImpl(FraudAlertRepository fraudAlertRepository) {
        this.fraudAlertRepository = fraudAlertRepository;
    }

    @Override
    public FraudAlert createAlert(FraudAlert alert) {
        return fraudAlertRepository.save(alert);
    }

    @Override
    public FraudAlert resolveAlert(Long id) {

        FraudAlert alert = fraudAlertRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Alert not found"));

        alert.setResolved(true);
        alert.setResolvedAt(LocalDateTime.now());

        return fraudAlertRepository.save(alert);
    }

    @Override
    public Optional<FraudAlert> getAlertById(Long id) {
        return fraudAlertRepository.findById(id);
    }

    @Override
    public List<FraudAlert> getAllAlerts() {
        return fraudAlertRepository.findAll();
    }
}
