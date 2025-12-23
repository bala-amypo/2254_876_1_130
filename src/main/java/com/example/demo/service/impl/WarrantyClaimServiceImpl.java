package com.example.demo.service.impl;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    @Autowired
    private WarrantyClaimRepository repository;

    @Override
    public WarrantyClaimRecord fileClaim(WarrantyClaimRecord claimRecord) {
        return repository.save(claimRecord);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return repository.findAll();
    }

    @Override
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsByDevice(DeviceOwnershipRecord deviceOwnershipRecord) {
        return repository.findByDeviceOwnershipRecord(deviceOwnershipRecord);
    }
}
