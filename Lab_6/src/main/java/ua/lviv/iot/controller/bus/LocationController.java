package ua.lviv.iot.controller.bus;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.bus.Location;
import ua.lviv.iot.dto.bus.LocationDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.bus.LocationMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.bus.LocationService;

@RequestMapping(value = "/locations")
@RestController
@AllArgsConstructor
public class LocationController extends AbstractController<Location, LocationDto, Integer> {
    private final LocationService locationService;
    private final LocationMapper locationMapper;

    @Override
    protected AbstractService<Location, Integer> getService() {
        return locationService;
    }

    @Override
    protected AbstractMapper<Location, LocationDto> getMapper() {
        return locationMapper;
    }
}
