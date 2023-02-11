package lk.ijse.metropolitan.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.metropolitan.bo.SuperBO;
import lk.ijse.metropolitan.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    String generateNextId() throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    boolean existsCus(String id) throws SQLException, ClassNotFoundException;

    CustomerDTO searchCus(String id) throws SQLException, ClassNotFoundException;

    boolean deleteCus(String id) throws SQLException, ClassNotFoundException;

    boolean addCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    boolean updateCus(CustomerDTO customer) throws SQLException, ClassNotFoundException;
}
