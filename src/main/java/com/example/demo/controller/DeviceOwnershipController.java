package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device", description = "Device Ownership APIs")
@RequiredArgsConstructor
public class DeviceOwnershipController {

    private final DeviceOwnershipService deviceService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeviceOwnershipRecord> registerDevice(@RequestBody DeviceOwnershipRecord device) {
        return ResponseEntity.ok(deviceService.registerDevice(device));
    }

    @GetMapping
    public ResponseEntity<List<DeviceOwnershipRecord>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceOwnershipRecord> getDeviceById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.getBySerial(id.toString()));
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<DeviceOwnershipRecord> getDeviceBySerial(@PathVariable String serialNumber) {
        return ResponseEntity.ok(deviceService.getBySerial(serialNumber));
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeviceOwnershipRecord> updateStatus(@PathVariable Long id,
                                                              @RequestParam boolean active) {
        return ResponseEntity.ok(deviceService.updateDeviceStatus(id, active));
    }
}
