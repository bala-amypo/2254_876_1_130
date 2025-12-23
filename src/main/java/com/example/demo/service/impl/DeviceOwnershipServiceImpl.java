package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    @Autowired
    private DeviceOwnershipRecordRepository repository;

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord deviceOwnershipRecord) {
        return repository.save(deviceOwnershipRecord);
    }

    @Override
    public Optional<DeviceOwnershipRecord> getBySerial(String serialNumber) {
        return repository.findByDeviceSerialNumber(serialNumber);
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        Optional<DeviceOwnershipRecord> optional = repository.findById(id);
        if (optional.isPresent()) {
            DeviceOwnershipRecord device = optional.get();
            device.setActive(active);
            return repository.save(device);
        }
        return null;
    }
}
