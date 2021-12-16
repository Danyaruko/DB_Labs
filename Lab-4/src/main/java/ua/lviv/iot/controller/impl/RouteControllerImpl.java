package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.entity.route.Route;
import ua.lviv.iot.model.dao.impl.RouteDaoImpl;

public class RouteControllerImpl extends AbstractControllerImpl<Route, Integer> {
    public RouteControllerImpl() {super(new RouteDaoImpl());}
}
