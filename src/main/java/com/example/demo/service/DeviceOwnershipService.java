package com.example.demo.service;

import com.example.demo.model.DeviceOwnership;

import java.util.List;

public interface DeviceOwnershipService {

    DeviceOwnership addDevice(DeviceOwnership deviceOwnership);

    List<DeviceOwnership> getAllDevices();

    DeviceOwnership getDeviceBySerial(String serialNumber);

    void deleteDevice(Long id);
}
