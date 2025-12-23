package com.example.demo.repository;

import com.example.demo.entity.FraudRuleRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRuleRecordRepository extends JpaRepository<FraudRuleRecord, Long> {}
