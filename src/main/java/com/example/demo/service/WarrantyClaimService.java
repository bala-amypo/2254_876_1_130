package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.WarrantyClaimRecord;

public interface WarrantyClaimService {
    List<WarrantyClaimRecord> getAllClaims();
}
