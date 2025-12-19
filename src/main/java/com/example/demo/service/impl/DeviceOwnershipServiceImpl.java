@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRepository deviceRepo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        if (deviceRepo.existsBySerialNumber(device.getSerialNumber())) {
            throw new IllegalArgumentException("Serial number already exists");
        }
        return deviceRepo.save(device);
    }

    @Override
    public DeviceOwnershipRecord getBySerial(String serialNumber) {
        return deviceRepo.findBySerialNumber(serialNumber)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return deviceRepo.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord device = deviceRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
        device.setActive(active);
        return deviceRepo.save(device);
    }
}
