package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody DeviceOwnershipRecord device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    @GetMapping
    public ResponseEntity<List<DeviceOwnershipRecord>> getAll() {
        return ResponseEntity.ok(service.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.updateDeviceStatus(id, true));
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<?> getBySerial(@PathVariable String serialNumber) {
        return ResponseEntity.ok(service.getBySerial(serialNumber));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,
                                          @RequestParam boolean active) {
        return ResponseEntity.ok(service.updateDeviceStatus(id, active));
    }
}
