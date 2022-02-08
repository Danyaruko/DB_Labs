package ua.lviv.iot.mapper.bus;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.bus.Location;
import ua.lviv.iot.dto.bus.LocationDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class LocationMapper extends AbstractMapper<Location, LocationDto> {

    @Override
    public LocationDto mapEntityToDto(Location location) {
        if (location == null)
            return null;

        LocationDto.LocationDtoBuilder locationDtoBuilder = LocationDto.builder();
        locationDtoBuilder.id(location.getId());
        locationDtoBuilder.country(location.getCountry());
        locationDtoBuilder.city(location.getCity());
        locationDtoBuilder.street(location.getStreet());

        return locationDtoBuilder.build();
    }
}
