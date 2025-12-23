package com.example.demo.service;

import com.example.demo.entity.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimService {

    WarrantyClaimRecord create(WarrantyClaimRecord claim);

    List<WarrantyClaimRecord> getAll();

    WarrantyClaimRecord getById(Long id);
}
