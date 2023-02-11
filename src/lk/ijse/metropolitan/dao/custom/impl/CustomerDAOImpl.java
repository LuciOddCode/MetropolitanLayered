package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.CustomerDAO;

import lk.ijse.metropolitan.dto.CrudUtil;
import lk.ijse.metropolitan.entity.Customer;
import lk.ijse.metropolitan.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    String sql=null;

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers =new ArrayList<>();
        sql= "SELECT * FROM customer;";
        ResultSet rst = CrudUtil.execute(sql);

        while (rst.next()){
            Customer customer=new Customer(rst.getString(1),rst.getString(2), rst.getString(3)
                    ,rst.getString(4), rst.getString(5),rst.getString(6) );

            allCustomers.add(customer);
        }

        return allCustomers;
    }

    @Override
    public boolean add(Customer entity) throws SQLException, ClassNotFoundException {
        sql="INSERT INTO customer VALUES (?,?,?,?,?,?)";

        return CrudUtil.execute(sql,entity.getcId(),entity.getName(),entity.getEmail()
        ,entity.getAddress(),entity.getPhone(),entity.getRegisteredBy());


    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        sql="UPDATE customer SET name=?,email=?,address=?,phone=?,registeredBy=? WHERE cId=?";
        return CrudUtil.execute(sql,entity.getName(),entity.getEmail()
                ,entity.getAddress(),entity.getPhone(),entity.getRegisteredBy(),entity.getcId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        sql= "SELECT * FROM customer WHERE cId=?;";
        ResultSet resultSet = CrudUtil.execute(sql, id);
        return resultSet.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        sql = "SELECT cId FROM customer ORDER BY cId DESC LIMIT 1;";
        ResultSet rst = CrudUtil.execute(sql);
        if (rst.next()) {
            String id = rst.getString("cId");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";

        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM customer WHERE cId=?;";
        return  CrudUtil.execute(sql, id);
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM customer WHERE cId LIKE ?";
        ResultSet result = CrudUtil.execute(sql, id);
        if (result.next()) {
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            );
        }
        return null;
    }
}
