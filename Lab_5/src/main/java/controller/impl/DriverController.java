package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.DriverDaoImpl;
import model.entities.Driver;

public class DriverController extends AbstractGenericControllerImpl<Driver>{

    private final DriverDaoImpl driverDao = new DriverDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Driver> getDao(){
        return driverDao;
    }
}
