package com.example.demo.service;

import com.example.demo.entity.FraudRuleRecord;
import java.util.List;

public interface FraudRuleService {

    FraudRuleRecord createRule(FraudRuleRecord rule);

    List<FraudRuleRecord> getAllRules();
}
