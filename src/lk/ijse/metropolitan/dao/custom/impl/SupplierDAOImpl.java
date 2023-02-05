package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.SupplierDAO;
import lk.ijse.metropolitan.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Supplier entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Supplier entity) throws SQLException, ClassNotFoundException {
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
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
