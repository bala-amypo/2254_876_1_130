package com.example.demo.service.impl;

import com.example.demo.entity.DeviceOwnership;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRepository repository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnership save(DeviceOwnership deviceOwnership) {
        return repository.save(deviceOwnership);
    }

    @Override
    public List<DeviceOwnership> getAll() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnership getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
