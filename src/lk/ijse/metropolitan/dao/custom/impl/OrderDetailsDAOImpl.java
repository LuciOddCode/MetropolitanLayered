package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.OrderDetailsDAO;
import lk.ijse.metropolitan.dto.CrudUtil;
import lk.ijse.metropolitan.entity.OrderDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetail> allOrderDetails = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM orderDetail;");
        while (resultSet.next()) {
            OrderDetail orderDetail = new OrderDetail(resultSet.getString("oId")
                    , resultSet.getString("prId"), resultSet.getDouble("qty")
                    , resultSet.getDouble("price"));

            allOrderDetails.add(orderDetail);

        }
        return allOrderDetails;
    }

    @Override
    public boolean add(OrderDetail od) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO orderDetail VALUES(?,?,?,?);",od.getoId(),od.getPrId(),od.getQty()
                ,od.getPrice());
    }

    @Override
    public boolean update(OrderDetail od) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE orderDetail SET prId=?,qty=?,price=? WHERE oId=?;",od.getPrId()
        ,od.getQty(),od.getPrice(),od.getoId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM orderDetail WHERE oId =?;",id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT oId FROM orderDetail ORDER BY oId DESC LIMIT 1;");
        if (rst.next()){
            String id = rst.getString("oId");
            int newOrderDetailId= Integer.parseInt(id.replace("0D00",""))+1;
            return String.format("OD00%03d",newOrderDetailId);
        }else return "OD00-001";

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM orderDetail WHERE oId =?;",id);
    }

    @Override
    public OrderDetail search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM orderDetail WHERE oId =?",id);
        if (rst.next()){
            return new OrderDetail(rst.getString("oId"),rst.getString("prId")
                    ,rst.getDouble("qty"),rst.getDouble("price"));
        }
        return null;
    }
}
