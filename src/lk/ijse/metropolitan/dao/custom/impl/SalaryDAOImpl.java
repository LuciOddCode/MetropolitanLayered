package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.SalaryDAO;
import lk.ijse.metropolitan.dto.CrudUtil;
import lk.ijse.metropolitan.entity.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public ArrayList<Salary> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Salary> salaries = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM salary;");
        while (rst.next()) {
            Salary salary = new Salary(rst.getString("slId"), rst.getString("month"), rst.getString("eId")
                    , rst.getString("designation"), rst.getDouble("salary"));
            salaries.add(salary);
        }
        return salaries;
    }

    @Override
    public boolean add(Salary s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO salary VALUES (?,?,?,?,?);",s.getSlId(),s.getMonth(),s.geteId()
                ,s.getDesignation(),s.getSalary());
    }

    @Override
    public boolean update(Salary s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE salary SET month=?,eId=?,designation=?,salary=? WHERE slId=?;",s.getMonth()
                ,s.geteId(),s.getDesignation(),s.getSalary(),s.getSlId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM salary WHERE slId =?;",id);
        return resultSet.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT slId FROM salary ORDER BY slId DESC LIMIT 1;");
        if (rst.next()){
            String id = rst.getString("slId");
            int newSalId= Integer.parseInt(id.replace("S00-",""))+1;
            return String.format("S00-%03d",newSalId);
        }else {
            return "S00-001";
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM salary WHERE slId=?;",id);
    }

    @Override
    public Salary search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM salary WHERE slId=?;",id);
        if (rst.next()){
            Salary salary = new Salary(rst.getString("slId"),rst.getString("month")
                    ,rst.getString("eId"),rst.getString("designation"),rst.getDouble("salary"));
            return salary;
        }
        return null;
    }
}
