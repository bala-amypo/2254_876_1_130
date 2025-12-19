package com.example.fraud.repository;

import com.example.fraud.entity.FraudRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FraudRuleRepository extends JpaRepository<FraudRule, Long> {

    Optional<FraudRule> findByRuleCode(String ruleCode);

    List<FraudRule> findByActiveTrue();
}
