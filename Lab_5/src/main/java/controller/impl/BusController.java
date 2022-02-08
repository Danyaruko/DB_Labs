package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.BusDaoImpl;
import model.entities.Bus;

public class BusController extends AbstractGenericControllerImpl<Bus>{

    private final BusDaoImpl transportTypeDao = new BusDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Bus> getDao(){
        return transportTypeDao;
    }
}
