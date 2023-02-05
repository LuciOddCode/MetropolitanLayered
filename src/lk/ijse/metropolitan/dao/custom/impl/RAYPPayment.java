package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.RAYPPaymentDAO;
import lk.ijse.metropolitan.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class RAYPPayment implements RAYPPaymentDAO {
    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Payment entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Payment entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Payment search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
