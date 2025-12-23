package com.example.demo.service.impl;

import com.example.demo.entity.FraudRuleRecord;
import com.example.demo.repository.FraudRuleRecordRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRecordRepository repository;

    public FraudRuleServiceImpl(FraudRuleRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRuleRecord save(FraudRuleRecord rule) {
        return repository.save(rule);
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
