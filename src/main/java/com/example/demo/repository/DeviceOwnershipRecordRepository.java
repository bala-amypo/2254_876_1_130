package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DeviceOwnershipRecord;

@Repository
public interface DeviceOwnershipRepository
        extends JpaRepository<DeviceOwnershipRecord, Long> {

    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
}
