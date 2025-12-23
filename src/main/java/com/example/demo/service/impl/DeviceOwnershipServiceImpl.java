package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnership;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnership registerDevice(DeviceOwnership device) {
        return repository.save(device);
    }

    @Override
    public List<DeviceOwnership> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnership getBySerial(String serialNumber) {
        return repository.findByDeviceSerialNumber(serialNumber)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @Override
    public DeviceOwnership updateDeviceStatus(Long id, boolean stolen) {
        DeviceOwnership device = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setStolen(stolen);
        return repository.save(device);
    }
}
