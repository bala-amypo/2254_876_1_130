package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl {

    @Autowired
    private StolenDeviceReportRepository reportRepo;

    public List<StolenDeviceReport> getReportsBySerialNumber(String serialNumber) {
        // Assuming one-to-many, change repository to return List
        return reportRepo.findByDeviceSerialNumber(serialNumber);
    }

    public void processReport(Long reportId) {
        Optional<StolenDeviceReport> reportOpt = reportRepo.findById(reportId);
        reportOpt.ifPresent(report -> {
            String serial = report.getDevice().getSerialNumber();
            // process using serial
            System.out.println("Processing stolen device with serial: " + serial);
        });
    }
}
