package com.example.demo.service.impl;

import com.example.demo.model.FraudAlert;
import com.example.demo.repository.FraudAlertRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    @Autowired
    private FraudAlertRepository repository;

    @Override
    public FraudAlert createAlert(FraudAlert alert) {
        return repository.save(alert);
    }

    @Override
    public List<FraudAlert> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public FraudAlert getAlertById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteAlert(Long id) {
        repository.deleteById(id);
    }
}
