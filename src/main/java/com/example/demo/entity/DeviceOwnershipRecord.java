@Entity
@Table(name = "device_ownership_records")
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String ownerName;

    @Column
    private String ownerEmail;

    @Column
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private LocalDate warrantyExpiration;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "deviceOwnershipRecord",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<WarrantyClaimRecord> claims = new ArrayList<>();

    @OneToMany(mappedBy = "deviceOwnershipRecord",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<StolenDeviceReport> stolenReports = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
