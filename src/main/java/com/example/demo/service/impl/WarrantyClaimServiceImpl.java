package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository repository;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return repository.findAll();
    }
}
