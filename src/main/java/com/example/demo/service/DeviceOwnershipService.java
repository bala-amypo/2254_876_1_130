package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;

import java.util.List;
import java.util.Optional;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);

    DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active);

    Optional<DeviceOwnershipRecord> getBySerial(String serialNumber);

    Optional<DeviceOwnershipRecord> getById(Long id);

    List<DeviceOwnershipRecord> getAllDevices();
}
