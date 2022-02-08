package ua.lviv.iot.repository.bus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.bus.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
