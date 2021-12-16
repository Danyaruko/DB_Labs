package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.LocationDaoImpl;
import ua.lviv.iot.model.entity.bus.Location;

public class LocationControllerImpl extends AbstractControllerImpl<Location, Integer> {
    public LocationControllerImpl() {super(new LocationDaoImpl());}
}
