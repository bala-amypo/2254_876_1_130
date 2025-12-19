// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.DeviceOwnershipRecord;
// import com.example.demo.service.DeviceOwnershipService;

// @RestController
// @RequestMapping("/api/devices")
// public class DeviceOwnershipController {

//     private final DeviceOwnershipService service;

//     public DeviceOwnershipController(DeviceOwnershipService service) {
//         this.service = service;
//     }

//     @PostMapping("/register")
//     public DeviceOwnershipRecord register(
//             @RequestBody DeviceOwnershipRecord device) {

//         return service.registerDevice(device);
//     }
// }
