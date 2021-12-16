package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.entity.bus.Bus;
import ua.lviv.iot.model.dao.impl.BusDaoImpl;

public class BusControllerImpl extends AbstractControllerImpl<Bus, Integer> {
    public BusControllerImpl() {super(new BusDaoImpl());}
}
