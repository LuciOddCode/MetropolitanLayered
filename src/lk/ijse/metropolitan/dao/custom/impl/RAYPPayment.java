package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.RAYPPaymentDAO;
import lk.ijse.metropolitan.dto.CrudUtil;
import lk.ijse.metropolitan.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RAYPPayment implements RAYPPaymentDAO {
    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Payment> allPayments = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT  FROM payment;");
        while (rst.next()){
            Payment payment =new Payment(rst.getString("pId"),rst.getString("appId")
            ,rst.getDate("paymentDate"),rst.getDouble("cost"),rst.getString("givenBy"));

            allPayments.add(payment);
        }
        return allPayments;
    }

    @Override
    public boolean add(Payment p) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO payment VALUES (?,?,?,?,?);",p.getpId(),p.getAppId()
        ,p.getPaymentDate(),p.getCost(),p.getGivenBy());
    }

    @Override
    public boolean update(Payment p) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE payment SET appId=?,paymentDate=?,cost=?,givenBy=? WHERE pId=?;"
                ,p.getAppId(),p.getPaymentDate(),p.getCost(),p.getGivenBy(),p.getpId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM payment WHERE pId=?;",id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT pId FROM payment ORDER BY pId DESC LIMIT ;");
        if (rst.next()){
            String id=rst.getString("pId");
            int newPayId = Integer.parseInt(id.replace("P00-",""))+1;
            return String.format("P00-%03d",newPayId);
        }else {
            return "P00-001";
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM payment WHERE pid =?;",id);
    }

    @Override
    public Payment search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM payment WHERE pId=?;");
        if (resultSet.next()){
            Payment payment =new Payment(resultSet.getString("pId"),resultSet.getString("appId")
                    ,resultSet.getDate("paymentDate"),resultSet.getDouble("cost"),resultSet.getString("givenBy"));

            return payment;
        }
        return null;
    }
}
