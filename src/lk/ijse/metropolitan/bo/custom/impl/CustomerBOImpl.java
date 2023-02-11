package lk.ijse.metropolitan.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.metropolitan.bo.custom.CustomerBO;
import lk.ijse.metropolitan.dao.DAOFactory;
import lk.ijse.metropolitan.dao.custom.CustomerDAO;
import lk.ijse.metropolitan.dto.CustomerDTO;
import lk.ijse.metropolitan.entity.Customer;
import lk.ijse.metropolitan.entity.Employee;
import lk.ijse.metropolitan.view.tm.EmployeeTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO dao = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return  dao.generateNewID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = dao.getAll();
        ArrayList<CustomerDTO> allCustomers=new ArrayList<>();
        for (Customer c:all){
            CustomerDTO customerDTO = new CustomerDTO(c.getcId(),c.getName(),c.getAddress(),c.getEmail(),c.getPhone()
                    ,c.getRegisteredBy());
            allCustomers.add(customerDTO);
        }

        return allCustomers;
    }

    @Override
    public boolean existsCus(String id) throws SQLException, ClassNotFoundException {
        return dao.exist(id);
    }

    @Override
    public CustomerDTO searchCus(String id) throws SQLException, ClassNotFoundException {
        Customer cus = dao.search(id);
        return new CustomerDTO(cus.getcId(),cus.getName(),cus.getAddress(),cus.getEmail(),cus.getPhone()
                ,cus.getRegisteredBy());
    }

    @Override
    public boolean deleteCus(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public boolean addCustomer(CustomerDTO cus) throws SQLException, ClassNotFoundException {
        return dao.add(new Customer(cus.getcId(),cus.getName(),cus.getEmail(),cus.getAddress()
                ,cus.getPhone(),cus.geteId()));
    }

    @Override
    public boolean updateCus(CustomerDTO cus) throws SQLException, ClassNotFoundException {
        return dao.update(new Customer(cus.getcId(),cus.getName(),cus.getEmail(),cus.getAddress()
                ,cus.getPhone(),cus.geteId()));
    }
}
