package com.example.controller;

import com.example.entity.WarrantyClaim;
import com.example.service.WarrantyClaimService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warranty-claims")
public class WarrantyClaimController {

    private final WarrantyClaimService warrantyClaimService;

    public WarrantyClaimController(WarrantyClaimService warrantyClaimService) {
        this.warrantyClaimService = warrantyClaimService;
    }

    @PostMapping
    public ResponseEntity<WarrantyClaim> createWarrantyClaim(
            @RequestBody WarrantyClaim warrantyClaim) {

        WarrantyClaim saved = warrantyClaimService.createWarrantyClaim(warrantyClaim);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
