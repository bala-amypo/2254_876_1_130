package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnership;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final DeviceOwnershipRecordRepository repository;

    public StolenDeviceServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnership reportStolenDevice(DeviceOwnership device) {
        device.setStolen(true); // assuming DeviceOwnership has a "stolen" field
        return repository.save(device);
    }

    @Override
    public List<DeviceOwnership> getAllStolenDevices() {
        return repository.findByStolenTrue();
    }
}
