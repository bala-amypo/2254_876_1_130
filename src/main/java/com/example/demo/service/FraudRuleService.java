package com.example.demo.service;

import com.example.demo.model.FraudRuleRecord;
import java.util.List;

public interface FraudRuleService {
    FraudRuleRecord createRule(FraudRuleRecord rule);
    List<FraudRuleRecord> getAllRules();
    FraudRuleRecord getRuleById(Long id);
    void deleteRule(Long id);
}
