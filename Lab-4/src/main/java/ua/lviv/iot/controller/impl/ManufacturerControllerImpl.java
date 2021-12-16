package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.entity.bus.Manufacturer;
import ua.lviv.iot.model.dao.impl.ManufacturerDaoImpl;

public class ManufacturerControllerImpl extends AbstractControllerImpl<Manufacturer, Integer> {
    public ManufacturerControllerImpl() {super(new ManufacturerDaoImpl());}
}
