package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
    public StolenDeviceReport getReportById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Request not found"));
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repository.findAll();
    }

    @Override
    public void deleteReport(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Request not found");
        }
        repository.deleteById(id);
    }
}
