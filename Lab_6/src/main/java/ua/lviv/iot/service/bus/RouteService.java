package ua.lviv.iot.service.bus;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.bus.Route;
import ua.lviv.iot.repository.bus.RouteRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class RouteService extends AbstractService<Route, Integer> {
    private final RouteRepository routeRepository;

    @Override
    protected JpaRepository<Route, Integer> getRepository() {
        return routeRepository;
    }
}
