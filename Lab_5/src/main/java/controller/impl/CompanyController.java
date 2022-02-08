package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.CompanyDaoImpl;
import model.entities.Company;

public class CompanyController extends AbstractGenericControllerImpl<Company> {
    private final CompanyDaoImpl companyDao = new CompanyDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Company> getDao(){
        return companyDao;
    }

}
