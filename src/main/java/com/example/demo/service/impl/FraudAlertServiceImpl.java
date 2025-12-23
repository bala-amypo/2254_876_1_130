package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository repository;

    @Autowired
    public FraudAlertServiceImpl(FraudAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public FraudAlertRecord getAlertById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void resolveAlert(Long id) {
        repository.findById(id).ifPresent(alert -> {
            alert.setResolved(true);
            repository.save(alert);
        });
    }
}
