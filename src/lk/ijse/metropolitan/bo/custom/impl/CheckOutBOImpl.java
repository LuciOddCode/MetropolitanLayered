package lk.ijse.metropolitan.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.metropolitan.bo.custom.CheckOutBO;
import lk.ijse.metropolitan.controller.LoginFormController;
import lk.ijse.metropolitan.dao.DAOFactory;
import lk.ijse.metropolitan.dao.custom.CustomerDAO;
import lk.ijse.metropolitan.dao.custom.OrderDAO;
import lk.ijse.metropolitan.dao.custom.OrderDetailsDAO;
import lk.ijse.metropolitan.dao.custom.ProductDAO;
import lk.ijse.metropolitan.db.DBConnection;
import lk.ijse.metropolitan.dto.OrderDTO;
import lk.ijse.metropolitan.dto.OrderDetailDTO;
import lk.ijse.metropolitan.dto.ProductDTO;
import lk.ijse.metropolitan.entity.OrderDetail;
import lk.ijse.metropolitan.entity.Orders;
import lk.ijse.metropolitan.entity.Product;
import lk.ijse.metropolitan.view.tm.CheckOutTM;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.metropolitan.controller.LoginFormController;

import static lk.ijse.metropolitan.controller.LoginFormController.currentUser;

public class CheckOutBOImpl implements CheckOutBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public boolean existsCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public ArrayList<ProductDTO> getAllProductID() throws SQLException, ClassNotFoundException {
        ArrayList<Product> all = productDAO.getAll();
        ArrayList<ProductDTO> allProducts = new ArrayList<>();
        for (Product p : all) {
            ProductDTO productDTO = new ProductDTO(p.getPrId(), p.getType(), p.getBrand(), p.getDescription()
                    , String.valueOf(p.getQtyOnHand()), String.valueOf(p.getBuyingPrice())
                    , String.valueOf(p.getSellingPrice()));
            allProducts.add(productDTO);
        }
        return allProducts;
    }

    @Override
    public ProductDTO loadProductDetails(String text) throws SQLException, ClassNotFoundException {
        Product search = productDAO.search(text);
        return new ProductDTO(search.getPrId(),search.getType(),search.getBrand(),search.getDescription()
                ,String.valueOf(search.getQtyOnHand()),String.valueOf(search.getBuyingPrice())
                ,String.valueOf(search.getSellingPrice()));
    }

    @Override
    public double getProductUnitPrice(String prId) throws SQLException, ClassNotFoundException {
        Product search = productDAO.search(prId);
        return search.getSellingPrice();
    }

    @Override
    public boolean placeOrder(OrderDTO dto, ObservableList<CheckOutTM> items) {

        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            boolean b1 = orderDAO.exist(dto.getoId());
            /*if order id already exist*/
            if (b1) {
                return false;
            }

            connection.setAutoCommit(false);
            //Save the Order to the order table
            Date date = Date.valueOf(dto.getOrderDate());
            boolean b2 = orderDAO.add(new Orders(dto.getoId(),dto.getcId(),currentUser,date,dto.getTotal()));
            if (!b2) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            for (CheckOutTM tm : items) {
                OrderDetail orderDetails = new OrderDetail(dto.getoId(),tm.getCode(),tm.getQty(),tm.getPrice());
                boolean b3 = orderDetailsDAO.add(orderDetails);
                if (!b3) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
                //Search & Update Item
                Product item = findItem(tm.getCode());
                item.setQtyOnHand(item.getQtyOnHand() - tm.getQty());

                //update item
                boolean b = productDAO.update(new Product(item.getPrId(),item.getType(),item.getBrand(),item.getDescription()
                ,item.getBuyingPrice(),item.getSellingPrice(),item.getQtyOnHand()));

                if (!b) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String nextOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }

    private Product findItem(String code) throws SQLException, ClassNotFoundException {
        return productDAO.search(code);
    }
}
