package lk.ijse.metropolitan.bo.custom.impl;

import lk.ijse.metropolitan.bo.custom.IncomeReportBO;
import lk.ijse.metropolitan.dao.DAOFactory;
import lk.ijse.metropolitan.dao.custom.OrderDAO;
import lk.ijse.metropolitan.dao.custom.OrderDetailsDAO;
import lk.ijse.metropolitan.dao.custom.ProductDAO;
import lk.ijse.metropolitan.dao.custom.RAYPPaymentDAO;

public class IncomeReportBOImpl implements IncomeReportBO {
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    RAYPPaymentDAO paymentDAO = (RAYPPaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RAYPP);


}
