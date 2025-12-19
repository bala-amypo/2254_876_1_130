package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl {

    private final DeviceOwnershipRepository deviceRepo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    public void deactivateDevice(String serialNumber) {
        Optional<DeviceOwnershipRecord> optionalDevice = deviceRepo.findBySerialNumber(serialNumber);
        if (optionalDevice.isPresent()) {
            DeviceOwnershipRecord device = optionalDevice.get();
            device.setActive(false);
            deviceRepo.save(device);
        }
    }
}
