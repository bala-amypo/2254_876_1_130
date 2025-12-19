package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/stolen-devices")
@Tag(name = "StolenDevice", description = "Stolen Device APIs")
public class StolenDeviceController {

    private final StolenDeviceService stolenDeviceService;

    public StolenDeviceController(StolenDeviceService stolenDeviceService) {
        this.stolenDeviceService = stolenDeviceService;
    }

    @PostMapping
    public ResponseEntity<StolenDeviceReport> reportStolen(
            @RequestBody StolenDeviceReport report
    ) {
        return ResponseEntity.ok(stolenDeviceService.reportStolen(report));
    }

    @GetMapping
    public ResponseEntity<List<StolenDeviceReport>> getAllReports() {
        return ResponseEntity.ok(stolenDeviceService.getAllReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StolenDeviceReport> getReportById(@PathVariable Long id) {
        return stolenDeviceService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new NoSuchElementException("Request not found"));
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<StolenDeviceReport>> getReportsBySerial(
            @PathVariable String serialNumber
    ) {
        return ResponseEntity.ok(
                stolenDeviceService.getReportsBySerial(serialNumber)
        );
    }
}
