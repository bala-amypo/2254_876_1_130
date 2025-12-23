package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.Builder;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fraud_alert_records")
@Builder
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "claim_id", nullable = false)
    private Long claimId;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String alertType;

    @Column(nullable = false)
    private String severity; // LOW/MEDIUM/HIGH/CRITICAL

    private String message;

    @Column(nullable = false, updatable = false)
    private LocalDateTime alertDate;

    @Column(nullable = false)
    private Boolean resolved = false;

    @ManyToOne
    @JoinColumn(name = "claim_id", insertable = false, updatable = false)
    @JsonIgnore
    private WarrantyClaimRecord claim;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        alertDate = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }
}
