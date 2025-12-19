package com.example.demo.service;

import com.example.demo.entity.DeviceOwnership;
import java.util.List;

public interface DeviceOwnershipService {

    DeviceOwnership save(DeviceOwnership deviceOwnership);

    List<DeviceOwnership> getAll();

    DeviceOwnership getById(Long id);
}
