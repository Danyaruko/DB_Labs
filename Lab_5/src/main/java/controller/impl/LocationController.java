package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.LocationDaoImpl;
import model.entities.Location;

public class LocationController extends AbstractGenericControllerImpl<Location>{
    private final LocationDaoImpl locationDao = new LocationDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Location> getDao(){
        return locationDao;
    }



}
