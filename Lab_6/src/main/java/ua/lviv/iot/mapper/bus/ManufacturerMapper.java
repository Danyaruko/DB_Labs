package ua.lviv.iot.mapper.bus;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.bus.Manufacturer;
import ua.lviv.iot.dto.bus.ManufacturerDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class ManufacturerMapper extends AbstractMapper<Manufacturer, ManufacturerDto> {

    @Override
    public ManufacturerDto mapEntityToDto(Manufacturer manufacturer) {
        if (manufacturer == null)
            return null;

        ManufacturerDto.ManufacturerDtoBuilder manufacturerDtoBuilder = ManufacturerDto.builder();
        manufacturerDtoBuilder.id(manufacturer.getId());
        manufacturerDtoBuilder.name(manufacturer.getName());
        manufacturerDtoBuilder.locationId(manufacturer.getLocation().getId());

        return manufacturerDtoBuilder.build();
    }
}
