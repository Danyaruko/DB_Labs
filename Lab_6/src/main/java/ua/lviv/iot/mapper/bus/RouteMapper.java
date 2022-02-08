package ua.lviv.iot.mapper.bus;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.bus.Route;
import ua.lviv.iot.dto.bus.RouteDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class RouteMapper extends AbstractMapper<Route, RouteDto> {

    @Override
    public RouteDto mapEntityToDto(Route route) {
        if (route == null)
            return null;

        RouteDto.RouteDtoBuilder routeDtoBuilder = RouteDto.builder();
        routeDtoBuilder.id(route.getId());
        routeDtoBuilder.startPoint(route.getStartPoint());
        routeDtoBuilder.endPoint(route.getEndPoint());
        routeDtoBuilder.routePriceEUR(route.getRoutePriceEUR());
        routeDtoBuilder.lengthKm(route.getLengthKm());

        return routeDtoBuilder.build();
    }
}
