package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;

import java.util.List;

public interface WarrantyClaimService {
    WarrantyClaimRecord submitClaim(String description, DeviceOwnershipRecord device);

    List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber);
}
