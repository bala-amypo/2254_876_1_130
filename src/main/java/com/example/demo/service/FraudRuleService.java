package com.example.demo.service;

import com.example.demo.entity.FraudRuleRecord;
import java.util.List;

public interface FraudRuleService {

    FraudRuleRecord save(FraudRuleRecord rule);

    List<FraudRuleRecord> getAll();

    FraudRuleRecord getById(Long id);
}
