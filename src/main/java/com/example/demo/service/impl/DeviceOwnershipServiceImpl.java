package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnership;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    @Autowired
    private DeviceOwnershipRecordRepository repository;

    @Override
    public DeviceOwnership addDevice(DeviceOwnership deviceOwnership) {
        return repository.save(deviceOwnership);
    }

    @Override
    public List<DeviceOwnership> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnership getDeviceBySerial(String serialNumber) {
        return repository.findByDeviceSerialNumber(serialNumber).orElse(null);
    }

    @Override
    public void deleteDevice(Long id) {
        repository.deleteById(id);
    }
}
