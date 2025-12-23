package com.example.demo.service;

import com.example.demo.model.DeviceOwnership;
import java.util.List;

public interface DeviceOwnershipService {
    DeviceOwnership create(DeviceOwnership ownership);
    List<DeviceOwnership> getAll();
    DeviceOwnership getById(Long id);
}
