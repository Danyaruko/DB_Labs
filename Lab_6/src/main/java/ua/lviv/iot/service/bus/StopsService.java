package ua.lviv.iot.service.bus;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.bus.Stops;
import ua.lviv.iot.repository.bus.StopsRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class StopsService extends AbstractService<Stops, Integer> {
    private final StopsRepository stopsRepository;

    @Override
    protected JpaRepository<Stops, Integer> getRepository() {
        return stopsRepository;
    }
}
