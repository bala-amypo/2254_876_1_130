package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {
    
    private final StolenDeviceService stolenDeviceService;
    
    public StolenDeviceController(StolenDeviceService stolenDeviceService) {
        this.stolenDeviceService = stolenDeviceService;
    }
    
    @PostMapping
    public ResponseEntity<StolenDeviceReport> reportStolen(@RequestBody StolenDeviceReport report) {
        return ResponseEntity.ok(stolenDeviceService.reportStolen(report));
    }
    
    @GetMapping
    public ResponseEntity<List<StolenDeviceReport>> getAllReports() {
        return ResponseEntity.ok(stolenDeviceService.getAllReports());
    }
    
    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<StolenDeviceReport>> getReportsBySerial(@PathVariable String serialNumber) {
        return ResponseEntity.ok(stolenDeviceService.getReportsBySerial(serialNumber));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StolenDeviceReport> getReportById(@PathVariable Long id) {
        Optional<StolenDeviceReport> report = stolenDeviceService.getReportById(id);
        return report.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        stolenDeviceService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}
