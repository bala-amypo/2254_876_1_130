package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/warranty-claims")
@Tag(name = "Warranty Claims", description = "Operations related to warranty claims")
public class WarrantyClaimController {

    private final WarrantyClaimRepository repository;

    public WarrantyClaimController(WarrantyClaimRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAllClaims() {
        return repository.findAll();
    }
}
