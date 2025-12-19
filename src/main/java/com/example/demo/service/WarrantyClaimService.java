package com.example.demo.service;

import java.util.List;

import com.example.demo.model.WarrantyClaimRecord;

public interface WarrantyClaimService {

    boolean isWarrantyValid(String serialNumber);

    List<WarrantyClaimRecord> getAllClaims();
}
