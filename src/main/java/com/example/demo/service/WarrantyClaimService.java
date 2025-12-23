package com.example.demo.service;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.model.DeviceOwnershipRecord;

import java.util.List;
import java.util.Optional;

public interface WarrantyClaimService {

    WarrantyClaimRecord fileClaim(WarrantyClaimRecord claimRecord);
    List<WarrantyClaimRecord> getAllClaims();
    Optional<WarrantyClaimRecord> getClaimById(Long id);
    List<WarrantyClaimRecord> getClaimsByDevice(DeviceOwnershipRecord deviceOwnershipRecord);
}
