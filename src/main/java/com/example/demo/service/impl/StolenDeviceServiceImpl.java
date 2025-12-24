package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository repository;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        return repository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public Optional<StolenDeviceReport> getReportById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repository.findAll();
    }
}
