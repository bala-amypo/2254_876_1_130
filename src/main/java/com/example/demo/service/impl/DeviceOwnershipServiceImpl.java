package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnership;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRepository repository;

    @Autowired
    public DeviceOwnershipServiceImpl(DeviceOwnershipRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnership create(DeviceOwnership ownership) {
        return repository.save(ownership);
    }

    @Override
    public List<DeviceOwnership> getAll() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnership getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("DeviceOwnership not found"));
    }
}
