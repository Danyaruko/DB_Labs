package ua.lviv.iot.mapper.driver;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.driver.Driver;
import ua.lviv.iot.dto.driver.DriverDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class DriverMapper extends AbstractMapper<Driver, DriverDto> {

    @Override
    public DriverDto mapEntityToDto(Driver driver) {
        if (driver == null)
            return null;

        DriverDto.DriverDtoBuilder driverDtoBuilder = DriverDto.builder();
        driverDtoBuilder.id(driver.getId());
        driverDtoBuilder.fullName(driver.getFullName());
        driverDtoBuilder.phoneNumber(driver.getPhoneNumber());
        driverDtoBuilder.email(driver.getEmail());

        return driverDtoBuilder.build();
    }
}
