package com.example.demo.repository;

import com.example.demo.model.FraudRuleRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRuleRepository extends JpaRepository<FraudRuleRecord, Long> {
}
