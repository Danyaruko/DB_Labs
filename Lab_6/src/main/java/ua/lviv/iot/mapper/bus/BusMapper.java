package ua.lviv.iot.mapper.bus;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.bus.Bus;
import ua.lviv.iot.dto.bus.BusDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class BusMapper extends AbstractMapper<Bus, BusDto> {

    @Override
    public BusDto mapEntityToDto(Bus bus) {
        if (bus == null)
            return null;

        BusDto.BusDtoBuilder busDtoBuilder = BusDto.builder();
        busDtoBuilder.id(bus.getId());
        busDtoBuilder.busNumber(bus.getBusNumber());
        busDtoBuilder.mileageKm(bus.getMileageKm());
        busDtoBuilder.age(bus.getAge());
        busDtoBuilder.seats(bus.getSeats());
        busDtoBuilder.idRoute(bus.getRoute().getId());
        busDtoBuilder.ownerCompanyId(bus.getCompany().getId());
        busDtoBuilder.manufacturerId(bus.getManufacturer().getId());


        return busDtoBuilder.build();
    }
}
