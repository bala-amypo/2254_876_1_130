package com.example.demo.service.impl;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRepository repository;

    public WarrantyClaimServiceImpl(WarrantyClaimRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarrantyClaimRecord create(WarrantyClaimRecord record) {
        return repository.save(record);
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public WarrantyClaimRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
