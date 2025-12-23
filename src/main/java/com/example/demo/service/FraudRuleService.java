package com.example.demo.service;

import com.example.demo.entity.FraudRuleRecord;
import java.util.List;

public interface FraudRuleService {
    List<FraudRuleRecord> getAll();
    FraudRuleRecord save(FraudRuleRecord record);
}
