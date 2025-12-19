package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.WarrantyClaimRecord;

@Repository
public interface WarrantyClaimRecordRepository
        extends JpaRepository<WarrantyClaimRecord, Long> {
}
