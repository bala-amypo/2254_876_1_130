package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

@Repository
public interface WarrantyClaimRepository extends JpaRepository<WarrantyClaimRecord, Long> {

    // Find all warranty claims by status
    List<WarrantyClaimRecord> findByStatus(String status);

    // Find all warranty claims that contain a keyword in the description
    List<WarrantyClaimRecord> findByClaimDescriptionContaining(String keyword);
}
