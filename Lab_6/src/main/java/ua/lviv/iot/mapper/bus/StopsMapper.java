package ua.lviv.iot.mapper.bus;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.bus.Stops;
import ua.lviv.iot.dto.bus.StopsDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class StopsMapper extends AbstractMapper<Stops, StopsDto> {

    @Override
    public StopsDto mapEntityToDto(Stops stops) {
        if (stops == null)
            return null;

        StopsDto.StopsDtoBuilder stopsDtoBuilder = StopsDto.builder();
        stopsDtoBuilder.id(stops.getId());
        stopsDtoBuilder.name(stops.getName());
        stopsDtoBuilder.priceEUR(stops.getPriceEUR());
        stopsDtoBuilder.distanceKm(stops.getDistanceKm());
        stopsDtoBuilder.previousStopId(stops.getPreviousStopId());

        return stopsDtoBuilder.build();
    }
}
