package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository ruleRepository;

    @Override
    public FraudRule createRule(FraudRule rule) {
        if (ruleRepository.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new IllegalArgumentException("Rule already exists");
        }
        return ruleRepository.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule updatedRule) {
        FraudRule existing = ruleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
        existing.setRuleCode(updatedRule.getRuleCode());
        existing.setRuleType(updatedRule.getRuleType());
        existing.setDescription(updatedRule.getDescription());
        existing.setActive(updatedRule.getActive());
        return ruleRepository.save(existing);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return ruleRepository.findByActiveTrue();
    }

    @Override
    public Optional<FraudRule> getRuleByCode(String ruleCode) {
        return ruleRepository.findByRuleCode(ruleCode);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
