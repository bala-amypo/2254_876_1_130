package com.example.demo.controller;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranty-claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping
    public WarrantyClaimRecord create(@RequestBody WarrantyClaimRecord claim) {
        return service.create(claim);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public WarrantyClaimRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
