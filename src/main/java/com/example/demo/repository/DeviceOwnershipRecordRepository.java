package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.DeviceOwnershipRecord;
import java.util.List;

@Repository
public interface DeviceOwnershipRepository extends JpaRepository<DeviceOwnershipRecord, Long> {

    // Find all device ownership records by owner name
    List<DeviceOwnershipRecord> findByOwnerName(String ownerName);

    // Find a device ownership record by device serial number
    DeviceOwnershipRecord findByDeviceSerial(String deviceSerial);
}
