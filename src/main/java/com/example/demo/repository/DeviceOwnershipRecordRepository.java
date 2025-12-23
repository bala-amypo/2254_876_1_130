package com.example.demo.repository;

import com.example.demo.model.DeviceOwnership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnership, Long> {
    List<DeviceOwnership> findByStolenTrue();
}
