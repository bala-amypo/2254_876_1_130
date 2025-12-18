package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl {

    private final DeviceOwnershipRecordRepository deviceRepository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Optional<DeviceOwnershipRecord> getDeviceBySerial(String serialNumber) {
        return deviceRepository.findBySerialNumber(serialNumber);
    }

    public DeviceOwnershipRecord saveDevice(DeviceOwnershipRecord device) {
        return deviceRepository.save(device);
    }
}
