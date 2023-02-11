package lk.ijse.metropolitan.bo.custom.impl;

import lk.ijse.metropolitan.bo.custom.RAYPPaymentBO;
import lk.ijse.metropolitan.dao.DAOFactory;
import lk.ijse.metropolitan.dao.custom.RAYPPaymentDAO;

public class RAYPPaymentBOImpl implements RAYPPaymentBO {
    RAYPPaymentDAO paymentDAO = (RAYPPaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RAYPP);
}
