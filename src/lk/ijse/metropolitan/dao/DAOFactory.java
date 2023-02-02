package lk.ijse.metropolitan.dao;

import lk.ijse.metropolitan.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER,PRODUCT,EMPLOYEE,USER,RAYPA,RAYPP,SALARY,SUPPLIER,STOCK,STOCK_DETAILS,ORDER,ORDER_DETAILS,QUERY_DAO
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case PRODUCT:
                return new ProductDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case USER:
                return new UserDAOImpl();
            case RAYPA:
                return new RAYPAppDAOImpl();
            case RAYPP:
                return new RAYPPAymentDAOImpl();
            case SALARY:
                return new SalaryDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case STOCK:
                return new StockDAOImpl();
            case STOCK_DETAILS:
                return new StockDetailDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAILS:
                return new OrderDetailsDAOImpl();
            case QUERY_DAO:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
