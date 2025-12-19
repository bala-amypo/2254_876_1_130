// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.WarrantyClaimRecord;
// import com.example.demo.service.WarrantyClaimService;

// @RestController
// @RequestMapping("/api/warranty")
// public class WarrantyClaimController {

//     private final WarrantyClaimService service;

//     public WarrantyClaimController(WarrantyClaimService service) {
//         this.service = service;
//     }

//     @GetMapping("/check/{serialNumber}")
//     public boolean checkWarranty(@PathVariable String serialNumber) {
//         return service.isWarrantyValid(serialNumber);
//     }

//     @GetMapping("/claims")
//     public List<WarrantyClaimRecord> getAllClaims() {
//         return service.getAllClaims();
//     }
// }
