package lk.ijse.metropolitan.bo.custom.impl;

import lk.ijse.metropolitan.bo.custom.EmployeeBO;
import lk.ijse.metropolitan.dao.DAOFactory;
import lk.ijse.metropolitan.dao.custom.EmployeeDAO;
import lk.ijse.metropolitan.dto.EmployeeDTO;
import lk.ijse.metropolitan.entity.Employee;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean saveEmp(EmployeeDTO eDTO) throws SQLException, ClassNotFoundException {
        Date dob = Date.valueOf(eDTO.getDOB());
        Employee employee = new Employee(eDTO.geteId(), eDTO.getName(), eDTO.getPhone(), dob, eDTO.getMail());
        return employeeDAO.add(employee);
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmp() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();
        ArrayList<Employee> all = employeeDAO.getAll();
        for (Employee e : all) {
            allEmployees.add(new EmployeeDTO(e.geteId(), e.getName(), e.getPhone(), e.getDOB().toLocalDate()
                    , e.getEmail()));
        }
        return allEmployees;
    }

    @Override
    public String generateNextEID() throws SQLException, ClassNotFoundException {
        return employeeDAO.generateNewID();
    }

    @Override
    public boolean exists(String eId) throws SQLException, ClassNotFoundException {
        boolean exist = employeeDAO.exist(eId);
        return exist;
    }

    @Override
    public boolean updateEmp(EmployeeDTO eDTO) throws SQLException, ClassNotFoundException {
        Date dob = Date.valueOf(eDTO.getDOB());
        Employee employee = new Employee(eDTO.geteId(), eDTO.getName(), eDTO.getPhone(), dob, eDTO.getMail());
        return employeeDAO.update(employee);
    }

    @Override
    public EmployeeDTO searchEmp(String id) throws SQLException, ClassNotFoundException {
        Employee em = employeeDAO.search(id);
        return new EmployeeDTO(em.geteId(), em.getName(), em.getPhone(), em.getDOB().toLocalDate(), em.getEmail());
    }

    @Override
    public boolean deleteEmp(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }
}
