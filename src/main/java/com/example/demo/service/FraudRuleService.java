package com.example.demo.service;

/* ===== IMPORTS ===== */
import com.example.demo.model.FraudRule;

import java.util.List;
import java.util.Optional;

public interface FraudRuleService {

    FraudRule createRule(FraudRule rule);

    FraudRule updateRule(Long id, FraudRule rule);

    Optional<FraudRule> getRuleByCode(String ruleCode);

    List<FraudRule> getActiveRules();

    List<FraudRule> getAllRules();
}
