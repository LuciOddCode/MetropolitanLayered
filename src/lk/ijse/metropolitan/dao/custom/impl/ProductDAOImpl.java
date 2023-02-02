package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.ProductDAO;
import lk.ijse.metropolitan.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public ArrayList<Product> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Product entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Product entity) throws SQLException, ClassNotFoundException {
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
    public Product search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
