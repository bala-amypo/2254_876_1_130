package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceOwnershipController {

    @Autowired
    private DeviceOwnershipService deviceService;

    @GetMapping("/{serialNumber}")
    public DeviceOwnershipRecord getDevice(@PathVariable String serialNumber) {
        return deviceService.findBySerialNumber(serialNumber);
    }

    @PostMapping("/activate/{serialNumber}")
    public String activateDevice(@PathVariable String serialNumber) {
        deviceService.activateDevice(serialNumber);
        return "Device activated: " + serialNumber;
    }
}
