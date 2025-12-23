package com.example.demo.repository;

import com.example.demo.model.DeviceOwnership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnership, Long> {
    Optional<DeviceOwnership> findByDeviceSerialNumber(String serialNumber);
}
