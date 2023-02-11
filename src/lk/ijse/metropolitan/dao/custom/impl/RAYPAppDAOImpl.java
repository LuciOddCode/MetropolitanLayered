package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.RAYPAppDAO;
import lk.ijse.metropolitan.dto.CrudUtil;
import lk.ijse.metropolitan.entity.RAYPAppointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RAYPAppDAOImpl implements RAYPAppDAO {
    @Override
    public ArrayList<RAYPAppointment> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<RAYPAppointment> allAppointments = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM RAYPAppointment;");
        while (resultSet.next()) {
            RAYPAppointment appointment = new RAYPAppointment(resultSet.getString("rId")
                    , resultSet.getString("cusomer"), resultSet.getDate("callDate")
                    , resultSet.getDate("appointmentDate"), resultSet.getString("description")
                    , resultSet.getString("appointedEmo"));

            allAppointments.add(appointment);
        }
        return allAppointments;
    }

    @Override
    public boolean add(RAYPAppointment ra) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO raypappointments VALUES (?,?,?,?,?,?);", ra.getrId(), ra.getCustomer()
                , ra.getCustomer(), ra.getCallDate(), ra.getAppointmentDate(), ra.getDescription(), ra.getAppointedEmp());
    }

    @Override
    public boolean update(RAYPAppointment entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE raypappointment SET customer=?,callDate=?,appointmentDate=?" +
                ",description=?,appointedEmp=? WHERE rId=?;");

    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM raypappointmet WHERE rId=?;",id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT rId FROM raypappointment ORDER BY rId DESC LIMIT 1;");
        if (rst.next()){
            String id= rst.getString("rId");
            int newRAYPAppId = Integer.parseInt(id.replace("RA00-",""))+1;
            return String.format("RA00-%03d",newRAYPAppId);

        }else {
            return "RA00-001";
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM raypappointment WHERE rId=?;",id);
    }

    @Override
    public RAYPAppointment search(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM raypappointment WHERE rId=?;",id);
        if (set.next()){
            RAYPAppointment app = new RAYPAppointment(set.getString("rId"),set.getString("customer")
            ,set.getDate("callDate"),set.getDate("appointmentDate"),set.getString("description")
                    ,set.getString("appointedEmp"));

            return app;
        }
        return null;
    }
}
