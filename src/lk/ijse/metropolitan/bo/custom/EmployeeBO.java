package lk.ijse.metropolitan.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.metropolitan.bo.SuperBO;
import lk.ijse.metropolitan.dto.EmployeeDTO;
import lk.ijse.metropolitan.entity.Employee;
import lk.ijse.metropolitan.view.tm.EmployeeTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {

    boolean saveEmp(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    ArrayList<EmployeeDTO> getAllEmp() throws SQLException, ClassNotFoundException;

    String generateNextEID() throws SQLException, ClassNotFoundException;


    boolean exists(String eId) throws SQLException, ClassNotFoundException;

    boolean updateEmp(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;

    EmployeeDTO searchEmp(String id) throws SQLException, ClassNotFoundException;

    boolean deleteEmp(String id) throws SQLException, ClassNotFoundException;

}

