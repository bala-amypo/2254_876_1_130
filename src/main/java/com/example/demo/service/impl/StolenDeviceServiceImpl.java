package com.example.demo.service.impl;

import com.example.demo.repository.DeviceOwnershipRepository;
import org.springframework.stereotype.Service;

@Service
public class StolenDeviceServiceImpl {

    private final DeviceOwnershipRepository deviceOwnershipRepository;

    public StolenDeviceServiceImpl(DeviceOwnershipRepository deviceOwnershipRepository) {
        this.deviceOwnershipRepository = deviceOwnershipRepository;
    }

    public void deactivateDevice(String serialNumber) {
        deviceOwnershipRepository.findBySerialNumber(serialNumber).ifPresent(device -> {
            device.setActive(false);
            deviceOwnershipRepository.save(device);
        });
    }
}
