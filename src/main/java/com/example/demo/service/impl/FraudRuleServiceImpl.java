package com.example.fraud.service.impl;

import com.example.fraud.entity.FraudRule;
import com.example.fraud.repository.FraudRuleRepository;
import com.example.fraud.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        if (repository.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new IllegalArgumentException("Rule already exists");
        }
        return repository.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule updatedRule) {
        FraudRule existingRule = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Fraud rule not found"));

        existingRule.setRuleCode(updatedRule.getRuleCode());
        existingRule.setRuleType(updatedRule.getRuleType());
        existingRule.setDescription(updatedRule.getDescription());
        existingRule.setActive(updatedRule.getActive());

        return repository.save(existingRule);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public Optional<FraudRule> getRuleByCode(String ruleCode) {
        return repository.findByRuleCode(ruleCode);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }
}











































