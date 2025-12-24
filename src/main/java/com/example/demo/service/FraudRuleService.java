package com.example.demo.service;

import com.example.demo.model.FraudRule;
import java.util.List;
import java.util.Optional;

public interface FraudRuleService {
    FraudRule createRule(FraudRule rule);
    List<FraudRule> getActiveRules();
    List<FraudRule> getAllRules();
    Optional<FraudRule> getRuleByCode(String ruleCode);
}
