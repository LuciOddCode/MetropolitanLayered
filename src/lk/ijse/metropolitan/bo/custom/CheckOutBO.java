package lk.ijse.metropolitan.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.metropolitan.bo.SuperBO;
import lk.ijse.metropolitan.dto.OrderDTO;
import lk.ijse.metropolitan.dto.ProductDTO;
import lk.ijse.metropolitan.view.tm.CheckOutTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CheckOutBO extends SuperBO {
    boolean existsCustomer(String text) throws SQLException, ClassNotFoundException;

    ArrayList<ProductDTO> getAllProductID() throws SQLException, ClassNotFoundException;

    ProductDTO loadProductDetails(String text) throws SQLException, ClassNotFoundException;

    double getProductUnitPrice(String prId) throws SQLException, ClassNotFoundException;

    boolean placeOrder(OrderDTO orderDTO, ObservableList<CheckOutTM> items);

    String nextOrderId() throws SQLException, ClassNotFoundException;
}
