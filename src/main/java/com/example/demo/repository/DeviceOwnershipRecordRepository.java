package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.DeviceOwnershipRecord;

/**
 * Repository for DeviceOwnershipRecord entity
 */
public interface DeviceOwnershipRepository extends JpaRepository<DeviceOwnershipRecord, Long> {
    // Add custom query methods here if needed
}
