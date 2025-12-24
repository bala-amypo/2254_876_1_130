package com.example.demo.service.impl;

/* ===== IMPORTS ===== */
import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        return fraudRuleRepository.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule rule) {
        rule.setId(id);
        return fraudRuleRepository.save(rule);
    }

    @Override
    public Optional<FraudRule> getRuleByCode(String ruleCode) {
        return fraudRuleRepository.findByRuleCode(ruleCode);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return fraudRuleRepository.findByActiveTrue();
    }

    @Override
    public List<FraudRule> getAllRules() {
        return fraudRuleRepository.findAll();
    }
}
