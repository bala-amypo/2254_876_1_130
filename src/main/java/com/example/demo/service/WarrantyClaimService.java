package com.example.demo.service;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.model.DeviceOwnership;

import java.util.List;

public interface WarrantyClaimService {

    WarrantyClaimRecord createClaim(DeviceOwnership device, String reason);
    List<WarrantyClaimRecord> getAllClaims();
    WarrantyClaimRecord getClaimById(Long id);
    WarrantyClaimRecord approveClaim(Long id);
}
