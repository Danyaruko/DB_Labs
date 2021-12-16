package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.entity.bus.Company;
import ua.lviv.iot.model.dao.impl.CompanyDaoImpl;

public class CompanyControllerImpl extends AbstractControllerImpl<Company, Integer> {
    public CompanyControllerImpl() {super(new CompanyDaoImpl());}
}
