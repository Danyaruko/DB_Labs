package ua.lviv.iot.controller.bus;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.bus.Manufacturer;
import ua.lviv.iot.dto.bus.ManufacturerDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.bus.ManufacturerMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.bus.ManufacturerService;

@RequestMapping(value = "/manufacturers")
@RestController
@AllArgsConstructor
public class ManufacturerController extends AbstractController<Manufacturer, ManufacturerDto, Integer> {
    private ManufacturerService manufacturerService;
    private ManufacturerMapper manufacturerMapper;

    @Override
    protected AbstractService<Manufacturer, Integer> getService() {
        return manufacturerService;
    }

    @Override
    protected AbstractMapper<Manufacturer, ManufacturerDto> getMapper() {
        return manufacturerMapper;
    }
}
