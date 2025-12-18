package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository alertRepository;

    public FraudAlertServiceImpl(FraudAlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return alertRepository.findAll();   // ✅ returns List
    }

    @Override
    public Optional<FraudAlertRecord> getAlertById(Long id) {
        return alertRepository.findById(id);   // ✅ returns Optional
    }

    @Override
    public void resolveAlert(Long id) {
        Optional<FraudAlertRecord> alert = alertRepository.findById(id);
        alert.ifPresent(a -> {
            a.setResolved(true);   // ✅ now works
            alertRepository.save(a);
        });
    }
}
