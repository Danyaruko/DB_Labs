package ua.lviv.iot.service.driver;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.driver.Driver;
import ua.lviv.iot.repository.driver.DriverRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class DriverService extends AbstractService<Driver, Integer> {
    private final DriverRepository patientRepository;

    @Override
    protected JpaRepository<Driver, Integer> getRepository() {
        return patientRepository;
    }
}
