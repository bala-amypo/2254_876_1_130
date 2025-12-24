package com.example.demo.service;

/* ===== IMPORTS ===== */
import com.example.demo.model.WarrantyClaimRecord;

import java.util.List;
import java.util.Optional;

public interface WarrantyClaimService {

    WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim);

    WarrantyClaimRecord updateClaimStatus(Long id, String status);

    Optional<WarrantyClaimRecord> getClaimById(Long id);

    List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber);

    List<WarrantyClaimRecord> getAllClaims();
}
