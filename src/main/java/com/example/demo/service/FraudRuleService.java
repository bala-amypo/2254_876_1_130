package com.example.demo.service;

import java.util.List;

// Correct import
import com.example.demo.entity.FraudRuleRecord;

public interface FraudRuleService {
    // Ensure the method matches the controller
    List<FraudRuleRecord> getAllFraudRules();
}
