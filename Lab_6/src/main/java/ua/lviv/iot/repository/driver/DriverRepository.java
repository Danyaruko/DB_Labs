package ua.lviv.iot.repository.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.driver.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
