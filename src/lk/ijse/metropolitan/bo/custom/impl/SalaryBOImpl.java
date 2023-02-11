package lk.ijse.metropolitan.bo.custom.impl;

import lk.ijse.metropolitan.bo.custom.SalaryBO;
import lk.ijse.metropolitan.dao.DAOFactory;
import lk.ijse.metropolitan.dao.custom.SalaryDAO;

public class SalaryBOImpl implements SalaryBO {
    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SALARY);
}
