package com.example.demo.service.impl;

import com.example.demo.entity.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.repository.StolenDeviceRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceRepository stolenRepo;
    private final DeviceOwnershipRepository deviceRepo;

    public StolenDeviceServiceImpl(StolenDeviceRepository stolenRepo,
                                   DeviceOwnershipRepository deviceRepo) {
        this.stolenRepo = stolenRepo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public StolenDeviceReport reportStolenDevice(StolenDeviceReport stolenDevice) {
        // Optional: Check if the device exists in the system before reporting
        if (!deviceRepo.existsById(stolenDevice.getDeviceId())) {
            throw new IllegalArgumentException("Device does not exist");
        }

        // Optional: Check if the device is already reported stolen
        if (stolenRepo.existsBySerialNumber(stolenDevice.getSerialNumber())) {
            throw new IllegalArgumentException("Device already reported stolen");
        }

        return stolenRepo.save(stolenDevice);
    }

    @Override
    public List<StolenDeviceReport> getAllStolenDevices() {
        return stolenRepo.findAll();
    }

    @Override
    public boolean isDeviceStolen(String serialNumber) {
        return stolenRepo.existsBySerialNumber(serialNumber);
    }
}
