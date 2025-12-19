package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;

public interface DeviceOwnershipService {
    DeviceOwnershipRecord findBySerialNumber(String serialNumber);
    void activateDevice(String serialNumber);
}
