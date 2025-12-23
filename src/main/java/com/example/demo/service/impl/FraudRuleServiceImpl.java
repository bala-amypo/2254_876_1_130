package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entity.FraudRuleRecord;
import com.example.demo.repository.FraudRuleRecordRepository;
import com.example.demo.service.FraudRuleService;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRecordRepository repository;

    public FraudRuleServiceImpl(FraudRuleRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FraudRuleRecord> getAllFraudRules() {
        return repository.findAll();
    }
}
