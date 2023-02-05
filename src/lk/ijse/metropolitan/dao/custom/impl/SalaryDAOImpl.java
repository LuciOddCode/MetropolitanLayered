package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.SalaryDAO;
import lk.ijse.metropolitan.entity.Salary;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public ArrayList<Salary> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Salary entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Salary entity) throws SQLException, ClassNotFoundException {
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
    public Salary search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
