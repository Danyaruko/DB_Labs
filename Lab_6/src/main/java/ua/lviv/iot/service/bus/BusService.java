package ua.lviv.iot.service.bus;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.bus.Bus;
import ua.lviv.iot.repository.bus.BusRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class BusService extends AbstractService<Bus, Integer> {
    private final BusRepository busRepository;

    @Override
    protected JpaRepository<Bus, Integer> getRepository() {
        return busRepository;
    }
}
