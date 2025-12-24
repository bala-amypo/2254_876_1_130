package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {
    private final FraudAlertRecordRepository repository;
    
    public FraudAlertServiceImpl(FraudAlertRecordRepository repository) {
        this.repository = repository;
    }
    
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return repository.save(alert);
    }
    
    public FraudAlertRecord create(FraudAlertRecord alert) {
        return repository.save(alert);
    }
    
    public List<FraudAlertRecord> getAll() {
        return repository.findAll();
    }
    
    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord alert = repository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Alert not found"));
        alert.setResolved(true);
        return repository.save(alert);
    }
    
    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return repository.findByClaimId(claimId);
    }
}
