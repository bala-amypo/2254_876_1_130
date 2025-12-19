// package com.example.demo.controller;

// import com.example.demo.model.StolenDeviceReport;
// import com.example.demo.service.StolenDeviceService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/stolen-devices")
// public class StolenDeviceController {

//     private final StolenDeviceService stolenDeviceService;

//     public StolenDeviceController(StolenDeviceService stolenDeviceService) {
//         this.stolenDeviceService = stolenDeviceService;
//     }

//     @PostMapping("/report")
//     public StolenDeviceReport reportDevice(
//             @RequestParam String serialNumber,
//             @RequestParam String reportedBy,
//             @RequestParam(required = false) String details
//     ) {
//         return stolenDeviceService.reportStolenDevice(serialNumber, reportedBy, details);
//     }
// }
