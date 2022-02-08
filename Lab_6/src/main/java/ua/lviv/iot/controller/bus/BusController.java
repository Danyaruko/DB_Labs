package ua.lviv.iot.controller.bus;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.bus.Bus;
import ua.lviv.iot.dto.bus.BusDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.bus.BusMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.bus.BusService;

@RequestMapping(value = "/buses")
@RestController
@AllArgsConstructor
public class BusController extends AbstractController<Bus, BusDto, Integer> {
    private final BusService busService;
    private final BusMapper busMapper;

    @Override
    protected AbstractService<Bus, Integer> getService() {
        return busService;
    }

    @Override
    protected AbstractMapper<Bus, BusDto> getMapper() {
        return busMapper;
    }
}
