package ua.lviv.iot.controller.driver;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.driver.Driver;
import ua.lviv.iot.dto.driver.DriverDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.driver.DriverMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.driver.DriverService;

@RequestMapping(value = "/drivers")
@RestController
@AllArgsConstructor
public class DriverController extends AbstractController<Driver, DriverDto, Integer> {
    private DriverService driverService;
    private DriverMapper driverMapper;

    @Override
    protected AbstractService<Driver, Integer> getService() {
        return driverService;
    }

    @Override
    protected AbstractMapper<Driver, DriverDto> getMapper() {
        return driverMapper;
    }
}
