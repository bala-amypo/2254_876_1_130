package com.example.demo.service;

import com.example.demo.model.FraudRuleRecord;
import java.util.List;

public interface FraudRuleService {

    FraudRuleRecord create(FraudRuleRecord record);

    List<FraudRuleRecord> getAll();

    FraudRuleRecord getById(Long id);
}
