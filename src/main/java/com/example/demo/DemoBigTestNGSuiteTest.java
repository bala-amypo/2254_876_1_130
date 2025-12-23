package com.example.demo;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.entity.FraudRuleRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.repository.FraudRuleRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@SpringBootTest
@Transactional
public class DemoBigTestNGSuiteTest {

    @Autowired
    private WarrantyClaimRecordRepository warrantyClaimRecordRepository;

    @Autowired
    private FraudRuleRecordRepository fraudRuleRecordRepository;

    private WarrantyClaimRecord testWarrantyClaim;
    private FraudRuleRecord testFraudRule;

    @BeforeClass
    public void setup() {
        // Create test WarrantyClaimRecord
        testWarrantyClaim = new WarrantyClaimRecord("CLM123", "John Doe", "Pending");
        warrantyClaimRecordRepository.save(testWarrantyClaim);

        // Create test FraudRuleRecord
        testFraudRule = new FraudRuleRecord("High Claim Amount", "Flag if claim > 10000");
        fraudRuleRecordRepository.save(testFraudRule);
    }

    @Test
    public void testCreateWarrantyClaim() {
        WarrantyClaimRecord claim = new WarrantyClaimRecord("CLM124", "Jane Doe", "Approved");
        WarrantyClaimRecord saved = warrantyClaimRecordRepository.save(claim);
        assertNotNull(saved.getId());
        assertEquals(saved.getCustomerName(), "Jane Doe");
    }

    @Test
    public void testGetAllWarrantyClaims() {
        List<WarrantyClaimRecord> claims = warrantyClaimRecordRepository.findAll();
        assertNotNull(claims);
        assertEquals(claims.size(), 2); // setup + testCreateWarrantyClaim
    }

    @Test
    public void testGetWarrantyClaimById() {
        WarrantyClaimRecord claim = warrantyClaimRecordRepository.findById(testWarrantyClaim.getId()).orElse(null);
        assertNotNull(claim);
        assertEquals(claim.getClaimNumber(), "CLM123");
    }

    @Test
    public void testCreateFraudRule() {
        FraudRuleRecord rule = new FraudRuleRecord("Suspicious Pattern", "Flag claims with suspicious pattern");
        FraudRuleRecord saved = fraudRuleRecordRepository.save(rule);
        assertNotNull(saved.getId());
        assertEquals(saved.getRuleName(), "Suspicious Pattern");
    }

    @Test
    public void testGetAllFraudRules() {
        List<FraudRuleRecord> rules = fraudRuleRecordRepository.findAll();
        assertNotNull(rules);
        assertEquals(rules.size(), 2); // setup + testCreateFraudRule
    }

    @Test
    public void testGetFraudRuleById() {
        FraudRuleRecord rule = fraudRuleRecordRepository.findById(testFraudRule.getId()).orElse(null);
        assertNotNull(rule);
        assertEquals(rule.getRuleName(), "High Claim Amount");
    }
}
