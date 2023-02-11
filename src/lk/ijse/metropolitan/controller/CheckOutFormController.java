package lk.ijse.metropolitan.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.CheckOutBO;
import lk.ijse.metropolitan.dto.OrderDTO;
import lk.ijse.metropolitan.dto.ProductDTO;
import lk.ijse.metropolitan.view.tm.CheckOutTM;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CheckOutFormController {
    private final ObservableList<CheckOutTM> obList = FXCollections.observableArrayList();
    public AnchorPane paneCheckOut;
    public Label lblDate;
    public TextField txtOID;
    public TextField txtCusID;
    public TextField txtPID;
    public TextField txtBrand;
    public ComboBox txtProType;
    public TextField txtDesc;
    public TextField txtQty;
    public TextField txtPrice;
    public Button btnAdd;
    public TableView<CheckOutTM> tblCart;
    public TableColumn colCode;
    public TableColumn colType;
    public TableColumn colBrand;
    public TableColumn colDesc;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableColumn colDel;
    public TextField txtTotal;
    public Button btnPlaceOrder;
    public Label lblChange;
    public TextField txtCash;
    public Label lblTotal;
    public Button btnClear;

    CheckOutBO checkOutBO = (CheckOutBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CO);

    public void initialize() {

        try {
            txtOID.setText(checkOutBO.nextOrderId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //set order date
        lblDate.setText("Date : " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        //next order id generate here
        // txtOID.setText(FrequentNeeds.nextID(Tables.ORDER));
        loadProductType();
        txtTotal.setText("0");
    }

    private void cellValueFactory() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("prId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDel.setCellValueFactory(new PropertyValueFactory<>("delete"));
    }

    private void loadProductType() {
        ObservableList<String> prType = FXCollections.observableArrayList();
        prType.addAll("PART", "PRODUCT", "REPAIR");
        txtProType.setItems(prType);
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {
        String oId = txtOID.getText();
        String cId = txtCusID.getText();
        LocalDate date = LocalDate.now();
        double total = Double.parseDouble(txtTotal.getText());
        boolean isPlaced = checkOutBO.placeOrder(new OrderDTO(oId, cId, date, total), tblCart.getItems());
        if (isPlaced){
            new Alert(Alert.AlertType.INFORMATION,"Order placed successfully");

        }else {
            new Alert(Alert.AlertType.INFORMATION,"Order failed");
        }

    }


    public void cidActionListener(ActionListener actionListener) {

    }

    public void pidAction(ActionEvent actionEvent) {
        ProductDTO pDTO = null;
        try {
            pDTO = checkOutBO.loadProductDetails(txtPID.getText());
            txtBrand.setText(pDTO.getBrand());
            txtDesc.setText(pDTO.getDesc());
            txtPrice.setText(pDTO.getSellingPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }


    public void brandAction(ActionEvent actionEvent) {
        txtDesc.requestFocus();
    }

    public void descAction(ActionEvent actionEvent) {
        txtQty.requestFocus();
    }

    public void qtyAction(ActionEvent actionEvent) {


    }

    public void addItemToCartOnAction(ActionEvent actionEvent) {
        String oId = txtOID.getText();
        String code = txtPID.getText();
        String type = String.valueOf(txtProType.getValue());
        String brand = txtBrand.getText();
        String desc = txtDesc.getText();
        double qty = Double.parseDouble(txtQty.getText());
        double unitPrice = getUnitPrice(code);
        double price = Double.parseDouble(txtPrice.getText());
        txtQty.setText("0");
        Double addToTotal = Double.parseDouble(txtTotal.getText()) + price;
        txtTotal.setText(String.valueOf(addToTotal));


        tblCart.getItems().add(new CheckOutTM(code, type, brand, desc, qty, price));


    }

    private double getUnitPrice(String prId) {
        try {
            return checkOutBO.getProductUnitPrice(prId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public void editQtyOnAction(TableColumn.CellEditEvent cellEditEvent) {

    }

    public void cashOnAction(ActionEvent actionEvent) {

    }

    public void cidAction(ActionEvent actionEvent) {
        boolean isExists = false;
        try {
            isExists = checkOutBO.existsCustomer(txtCusID.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (!isExists) {
            new Alert(Alert.AlertType.INFORMATION, "Theres no customer with that ID");
        } else {
            txtPID.requestFocus();
        }
    }

    public void ClearOnAction(ActionEvent actionEvent) {
    }
}
