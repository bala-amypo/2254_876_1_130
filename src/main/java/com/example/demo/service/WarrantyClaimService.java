package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;

import java.util.List;
import java.util.Optional;

public interface WarrantyClaimService {
    WarrantyClaimRecord createClaim(WarrantyClaimRecord claim);
    List<WarrantyClaimRecord> getAllClaims();
    Optional<WarrantyClaimRecord> getClaimById(Long id);
    WarrantyClaimRecord updateClaimStatus(Long id, String status);
    void deleteClaim(Long id);
    String getClaimReason(Long id);
    List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber);
}
