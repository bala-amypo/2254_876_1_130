package com.example.repository;

import com.example.entity.WarrantyClaim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarrantyClaimRepository
        extends JpaRepository<WarrantyClaim, Long> {
}
