package com.example.demo.service.impl;

import com.example.demo.entity.FraudRuleRecord;
import com.example.demo.repository.FraudRuleRecordRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    @Autowired
    private FraudRuleRecordRepository repository;

    @Override
    public FraudRuleRecord create(FraudRuleRecord record) {
        return repository.save(record);
    }

    @Override
    public List<FraudRuleRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public FraudRuleRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
