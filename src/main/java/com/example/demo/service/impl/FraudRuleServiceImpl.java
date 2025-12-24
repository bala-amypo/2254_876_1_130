package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {
    private final FraudRuleRepository repository;
    
    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }
    
    public FraudRule createRule(FraudRule rule) {
        if (repository.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new IllegalArgumentException("Rule code already exists");
        }
        return repository.save(rule);
    }
    
    public List<FraudRule> getActiveRules() {
        return repository.findByActiveTrue();
    }
    
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }
    
    public Optional<FraudRule> getRuleByCode(String ruleCode) {
        return repository.findByRuleCode(ruleCode);
    }
}
