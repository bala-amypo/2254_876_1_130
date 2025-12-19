package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    @Autowired
    private DeviceOwnershipRepository deviceRepo;

    @Override
    public DeviceOwnershipRecord findBySerialNumber(String serialNumber) {
        return deviceRepo.findBySerialNumber(serialNumber);
    }

    @Override
    public void activateDevice(String serialNumber) {
        DeviceOwnershipRecord device = deviceRepo.findBySerialNumber(serialNumber);
        if (device != null) {
            device.setActive(true);
            deviceRepo.save(device);
        }
    }
}
