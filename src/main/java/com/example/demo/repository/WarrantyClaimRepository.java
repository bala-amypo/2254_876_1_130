package com.example.demo.repository;

import com.example.demo.entity.WarrantyClaimRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarrantyClaimRepository extends JpaRepository<WarrantyClaimRecord, Long> {
    // You can add custom query methods here if needed
}
