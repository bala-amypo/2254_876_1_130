package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepository;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository stolenRepository) {
        this.stolenRepository = stolenRepository;
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenRepository.findAll();
    }

    @Override
    public StolenDeviceReport reportStolenDevice(StolenDeviceReport report) {
        report.setStatus("REPORTED");
        return stolenRepository.save(report);
    }

    @Override
    public Optional<StolenDeviceReport> findBySerialNumber(String serialNumber) {
        return stolenRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Optional<StolenDeviceReport> getReportById(Long id) {
        return stolenRepository.findById(id);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return stolenRepository.findAll().stream()
                .filter(r -> r.getSerialNumber().equals(serialNumber))
                .toList();
    }
}
