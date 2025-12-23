package com.example.demo.service.impl;

import com.example.demo.model.FraudRuleRecord;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    @Autowired
    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRuleRecord createRule(FraudRuleRecord rule) {
        return repository.save(rule);
    }

    @Override
    public List<FraudRuleRecord> getAllRules() {
        return repository.findAll();
    }

    @Override
    public FraudRuleRecord getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
