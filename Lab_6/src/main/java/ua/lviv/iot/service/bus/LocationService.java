package ua.lviv.iot.service.bus;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.bus.Location;
import ua.lviv.iot.repository.bus.LocationRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class LocationService extends AbstractService<Location, Integer> {
    private final LocationRepository locationRepository;

    @Override
    protected JpaRepository<Location, Integer> getRepository() {
        return locationRepository;
    }
}
