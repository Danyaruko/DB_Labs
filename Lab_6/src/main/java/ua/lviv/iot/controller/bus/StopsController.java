package ua.lviv.iot.controller.bus;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.bus.Stops;
import ua.lviv.iot.dto.bus.StopsDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.bus.StopsMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.bus.StopsService;

@RequestMapping(value = "/stops")
@RestController
@AllArgsConstructor
public class StopsController extends AbstractController<Stops, StopsDto, Integer> {
    private final StopsService stopsService;
    private final StopsMapper stopsMapper;

    @Override
    protected AbstractService<Stops, Integer> getService() {
        return stopsService;
    }

    @Override
    protected AbstractMapper<Stops, StopsDto> getMapper() {
        return stopsMapper;
    }
}
