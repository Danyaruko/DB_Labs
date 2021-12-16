package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.entity.route.Stops;
import ua.lviv.iot.model.dao.impl.StopsDaoImpl;

public class StopsControllerImpl extends AbstractControllerImpl<Stops, Integer> {
    public StopsControllerImpl() {super(new StopsDaoImpl());}
}
