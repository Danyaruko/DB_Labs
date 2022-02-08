package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.ManufacturerDaoImpl;
import model.entities.Manufacturer;

public class ManufacturerController extends AbstractGenericControllerImpl<Manufacturer>{

    private final ManufacturerDaoImpl manufacturerDao = new ManufacturerDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Manufacturer> getDao(){
        return manufacturerDao;
    }
}
