package com.example.demo.service.impl;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository repository;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarrantyClaimRecord create(WarrantyClaimRecord claim) {
        return repository.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public WarrantyClaimRecord getById(Long id) {
        Optional<WarrantyClaimRecord> claim = repository.findById(id);
        return claim.orElse(null);
    }
}
