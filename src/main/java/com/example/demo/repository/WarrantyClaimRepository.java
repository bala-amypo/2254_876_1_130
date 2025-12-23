package com.example.demo.repository;

import com.example.demo.entity.WarrantyClaimRecord;
import org.springframework.data.jpa.repository.JpaRepository;

// ✅ File name must match interface name
public interface WarrantyClaimRecordRepository extends JpaRepository<WarrantyClaimRecord, Long> {
}
