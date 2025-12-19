package com.example.demo.controller;

import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/device-ownership")
public class DeviceOwnershipController {

    private final DeviceOwnershipService deviceOwnershipService;

    public DeviceOwnershipController(DeviceOwnershipService deviceOwnershipService) {
        this.deviceOwnershipService = deviceOwnershipService;
    }
}
