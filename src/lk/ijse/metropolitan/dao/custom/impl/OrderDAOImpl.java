package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.OrderDAO;
import lk.ijse.metropolitan.dto.CrudUtil;
import lk.ijse.metropolitan.entity.Employee;
import lk.ijse.metropolitan.entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<Orders> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Orders> allOrders = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM orders;");
        while (rst.next()){
            Orders orders = new Orders(rst.getString("oId")
            ,rst.getString("cId")
            ,rst.getString("uId")
            ,rst.getDate("orderDate")
            ,rst.getDouble("total"));

            allOrders.add(orders);
        }
        return allOrders;
    }

    @Override
    public boolean add(Orders entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO orders VALUES (?,?,?,?,?);",entity.getoId(),entity.getcId()
        ,entity.getuId(),entity.getOrderDate(),entity.getTotal());

    }

    @Override
    public boolean update(Orders o) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE orders SET cId=?,uId=?,orderDate=?,total=? WHERE oId=?;",o.getcId()
        ,o.getuId(),o.getOrderDate(),o.getTotal(),o.getoId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM orders WHERE oId =?;",id);
        return  rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT oId FROM orders ORDER BY oId DESC LIMIT 1;");
        if (rst.next()){
            String id = rst.getString("oId");
            int newOrderId=Integer.parseInt(id.replace("O00-", "")) + 1;
            return String.format("O00-%03d", newOrderId);
        } else {
            return "O00-001";

        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Orders WHERE oId=?;",id);

    }

    @Override
    public Orders search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.execute("SELECT * FROM orders WHERE oId = ?; ",id);
        rst.next();
        Orders orders= new Orders(rst.getString("oId"),rst.getString("cId")
                ,rst.getString("uId"),rst.getDate("orderDate"),rst.getDouble("total"));
        return orders;
    }
}
