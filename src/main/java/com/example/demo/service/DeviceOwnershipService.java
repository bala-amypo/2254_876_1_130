package com.example.demo.service;

import com.example.demo.model.DeviceOwnership;
import java.util.List;

public interface DeviceOwnershipService {
    DeviceOwnership registerDevice(DeviceOwnership device);
    List<DeviceOwnership> getAllDevices();
    DeviceOwnership getBySerial(String serialNumber);
    DeviceOwnership updateDeviceStatus(Long id, boolean stolen);
}
