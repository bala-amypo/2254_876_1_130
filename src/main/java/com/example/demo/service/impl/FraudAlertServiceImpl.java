package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository repository;

    @Override
    public FraudAlertRecord create(FraudAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public FraudAlertRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
