package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    @Autowired
    private DeviceOwnershipService deviceOwnershipService;

    @PostMapping("/register")
    public ResponseEntity<DeviceOwnershipRecord> registerDevice(@RequestBody DeviceOwnershipRecord deviceOwnershipRecord) {
        DeviceOwnershipRecord saved = deviceOwnershipService.registerDevice(deviceOwnershipRecord);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/serial/{serial}")
    public ResponseEntity<DeviceOwnershipRecord> getBySerial(@PathVariable String serial) {
        return deviceOwnershipService.getBySerial(serial)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<DeviceOwnershipRecord> updateDeviceStatus(@PathVariable Long id, @RequestParam boolean active) {
        DeviceOwnershipRecord updated = deviceOwnershipService.updateDeviceStatus(id, active);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
