package com.example.service.impl;

import com.example.entity.WarrantyClaim;
import com.example.repository.WarrantyClaimRepository;
import com.example.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRepository warrantyClaimRepository;

    public WarrantyClaimServiceImpl(WarrantyClaimRepository warrantyClaimRepository) {
        this.warrantyClaimRepository = warrantyClaimRepository;
    }

    @Override
    public WarrantyClaim createWarrantyClaim(WarrantyClaim warrantyClaim) {
        return warrantyClaimRepository.save(warrantyClaim);
    }
}
