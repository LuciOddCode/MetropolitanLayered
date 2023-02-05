package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.StockDAO;
import lk.ijse.metropolitan.entity.StockSheet;

import java.sql.SQLException;
import java.util.ArrayList;

public class StockDAOImpl implements StockDAO {
    @Override
    public ArrayList<StockSheet> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(StockSheet entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(StockSheet entity) throws SQLException, ClassNotFoundException {
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
    public StockSheet search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
