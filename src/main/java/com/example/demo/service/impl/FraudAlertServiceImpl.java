package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository repository;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudAlertRecord create(FraudAlertRecord record) {
        return repository.save(record);
    }

    @Override
    public List<FraudAlertRecord> getAll() {
        return repository.findAll();
    }
}
