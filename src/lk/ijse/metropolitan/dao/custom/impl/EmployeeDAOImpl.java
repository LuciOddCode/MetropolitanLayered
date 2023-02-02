package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.EmployeeDAO;
import lk.ijse.metropolitan.dto.CrudUtil;
import lk.ijse.metropolitan.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    String sql =null;
    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> allEmployees =new ArrayList<>();
        sql= "SELECT * FROM employee;";
        ResultSet rst = CrudUtil.execute(sql);

        while (rst.next()){
            Employee employee=new Employee(rst.getString("eId"),rst.getString("name")
                    ,rst.getString("phone"),rst.getDate("DOB")
                    ,rst.getString("email"));

            allEmployees.add(employee);
        }

        return allEmployees;
    }

    @Override
    public boolean add(Employee e) throws SQLException, ClassNotFoundException {
        sql="INSERT INTO employee VALUES (?,?,?,?,?);";
        return  CrudUtil.execute(sql, e.geteId(), e.getName(), e.getPhone(), e.getDOB(), e.getEmail());

    }

    @Override
    public boolean update(Employee e) throws SQLException, ClassNotFoundException {
        sql="UPDATE employee SET name=?,phone=?,DOB=?,email=? WHERE eId=?;";
        return CrudUtil.execute(sql,e.getName(),e.getPhone(),e.getDOB(),e.getEmail(),e.geteId());


    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        sql="SELECT eId FROM employee WHERE eId=?;";
        ResultSet rst = CrudUtil.execute(sql, id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT eId FROM employee ORDER BY eId DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("eId");
            int newEmployeeId = Integer.parseInt(id.replace("E00-", "")) + 1;
            return String.format("E00-%03d", newEmployeeId);
        } else {
            return "E00-001";
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        sql="DELETE FROM employee WHERE eId =?;";
        return  CrudUtil.execute(sql,id);
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        sql="SELECT * FROM employee WHERE eId = ?; ";
        ResultSet rst=CrudUtil.execute(sql,id);
        rst.next();
        Employee employee = new Employee(rst.getString("eId"),rst.getString("name")
                ,rst.getString("phone"),rst.getDate("DOB"),rst.getString("email"));
        return employee;
    }
}
