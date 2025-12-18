package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;
import java.util.Optional;

public interface WarrantyClaimService {
    List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber);
    WarrantyClaimRecord resolveClaim(WarrantyClaimRecord claim);

    // Additional methods for controller
    WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim);
    List<WarrantyClaimRecord> getAllClaims();
    Optional<WarrantyClaimRecord> getClaimById(Long id);
    WarrantyClaimRecord updateClaimStatus(Long id, String status);
}
