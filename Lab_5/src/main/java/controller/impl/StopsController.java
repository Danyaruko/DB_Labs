package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.StopsDaoImpl;
import model.entities.Stops;

public class StopsController extends AbstractGenericControllerImpl<Stops>{
    private final StopsDaoImpl stopsDao = new StopsDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Stops> getDao(){
        return stopsDao;
    }
}
