package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;

import java.util.List;

public interface WarrantyClaimService {
    List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber);
    WarrantyClaimRecord resolveClaim(WarrantyClaimRecord claim);
}
