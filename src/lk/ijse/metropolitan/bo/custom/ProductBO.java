package lk.ijse.metropolitan.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.metropolitan.bo.SuperBO;
import lk.ijse.metropolitan.dto.ProductDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductBO extends SuperBO {
    ArrayList<ProductDTO> getAllProducts() throws SQLException, ClassNotFoundException;

    String generateNextId() throws SQLException, ClassNotFoundException;

    boolean addProduct(ProductDTO product) throws SQLException, ClassNotFoundException;

    boolean updateProduct(ProductDTO prduct) throws SQLException, ClassNotFoundException;

    boolean exist(String text) throws SQLException, ClassNotFoundException;

    ProductDTO searchProduct(String text) throws SQLException, ClassNotFoundException;

    boolean deleteProduct(String text) throws SQLException, ClassNotFoundException;
}
