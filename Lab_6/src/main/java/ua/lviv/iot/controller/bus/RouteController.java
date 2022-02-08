package ua.lviv.iot.controller.bus;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.bus.Route;
import ua.lviv.iot.dto.bus.RouteDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.bus.RouteMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.bus.RouteService;

@RequestMapping(value = "/routes")
@RestController
@AllArgsConstructor
public class RouteController extends AbstractController<Route, RouteDto, Integer> {
    private RouteService routeService;
    private RouteMapper routeMapper;

    @Override
    protected AbstractService<Route, Integer> getService() {
        return routeService;
    }

    @Override
    protected AbstractMapper<Route, RouteDto> getMapper() {
        return routeMapper;
    }
}
