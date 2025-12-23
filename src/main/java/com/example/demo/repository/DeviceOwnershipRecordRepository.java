package com.example.demo.repository;

import com.example.demo.model.DeviceOwnership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceOwnershipRepository extends JpaRepository<DeviceOwnership, Long> {
    // Additional queries if needed
}
