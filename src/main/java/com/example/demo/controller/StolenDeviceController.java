package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService stolenDeviceService;

    public StolenDeviceController(StolenDeviceService stolenDeviceService) {
        this.stolenDeviceService = stolenDeviceService;
    }

    // ✅ REPORT STOLEN DEVICE
    @PostMapping
    public ResponseEntity<StolenDeviceReport> reportStolen(
            @RequestBody StolenDeviceReport report
    ) {
        return ResponseEntity.ok(
                stolenDeviceService.reportStolen(report)
        );
    }

    // ✅ GET ALL REPORTS
    @GetMapping
    public ResponseEntity<List<StolenDeviceReport>> getAllReports() {
        return ResponseEntity.ok(
                stolenDeviceService.getAllReports()
        );
    }

    // ✅ GET REPORT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<StolenDeviceReport> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                stolenDeviceService.getReportById(id)
        );
    }

    // ✅ GET REPORTS BY SERIAL NUMBER
    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<StolenDeviceReport>> getBySerial(
            @PathVariable String serialNumber
    ) {
        return ResponseEntity.ok(
                stolenDeviceService.getReportsBySerial(serialNumber)
        );
    }

    // ✅ DELETE REPORT
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(
            @PathVariable Long id
    ) {
        stolenDeviceService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}
