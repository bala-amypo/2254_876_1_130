package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/warranty")
public class WarrantyClaimController {

    private final WarrantyClaimService claimService;

    public WarrantyClaimController(WarrantyClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/submit")
    public WarrantyClaimRecord submitClaim(@RequestBody WarrantyClaimRecord claim) {
        return claimService.submitClaim(claim);
    }

    @GetMapping("/all")
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public Optional<WarrantyClaimRecord> getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @PutMapping("/update/{id}")
    public WarrantyClaimRecord updateClaimStatus(@PathVariable Long id, @RequestParam String status) {
        return claimService.updateClaimStatus(id, status);
    }
}
