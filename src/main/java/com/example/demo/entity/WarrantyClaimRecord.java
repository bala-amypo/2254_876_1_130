package com.example.demo.model;

/* ===== IMPORTS ===== */
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

/* ===== ENTITY ===== */
@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecord {

    /* ===== FIELDS ===== */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private String claimantName;

    private String claimantEmail;

    private String claimReason;

    private String status = "PENDING";

    private LocalDateTime submittedAt;

    private LocalDateTime createdAt;

    /* ===== CONSTRUCTORS ===== */
    public WarrantyClaimRecord() {
    }

    /* ===== LIFECYCLE CALLBACK ===== */
    @PrePersist
    public void onCreate() {
        this.submittedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    /* ===== GETTERS ===== */
    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public String getClaimantEmail() {
        return claimantEmail;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /* ===== SETTERS ===== */
    public void setId(Long id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }

    public void setClaimantEmail(String claimantEmail) {
        this.claimantEmail = claimantEmail;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
