package com.example.demo.service.impl;

import com.example.demo.repository.FraudAlertRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FraudAlertServiceImpl {

    private final FraudAlertRepository fraudAlertRepository;
}
