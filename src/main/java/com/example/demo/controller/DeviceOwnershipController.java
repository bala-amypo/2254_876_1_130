package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device Ownership")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceOwnershipRecord> registerDevice(
            @RequestBody DeviceOwnershipRecord device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DeviceOwnershipRecord> updateStatus(
            @PathVariable Long id,
            @RequestParam("active") boolean active) {
        return ResponseEntity.ok(service.updateDeviceStatus(id, active));
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<DeviceOwnershipRecord> getBySerial(
            @PathVariable String serialNumber) {
        return ResponseEntity.ok(service.getBySerial(serialNumber));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceOwnershipRecord> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DeviceOwnershipRecord>> getAll() {
        return ResponseEntity.ok(service.getAllDevices());
    }
}
