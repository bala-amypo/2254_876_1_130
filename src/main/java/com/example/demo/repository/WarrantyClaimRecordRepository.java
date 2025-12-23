import com.example.demo.model.WarrantyClaimRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WarrantyClaimRecordRepository extends JpaRepository<WarrantyClaimRecord, Long> {
    // Use property navigation: device.serialNumber
    List<WarrantyClaimRecord> findByDevice_SerialNumber(String serialNumber);
}
`