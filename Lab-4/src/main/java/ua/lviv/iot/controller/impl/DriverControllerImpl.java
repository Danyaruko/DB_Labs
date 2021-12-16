package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.entity.driver.Driver;
import ua.lviv.iot.model.dao.impl.DriverDaoImpl;

public class DriverControllerImpl extends AbstractControllerImpl<Driver, Integer> {
    public DriverControllerImpl() {super(new DriverDaoImpl());}
}
