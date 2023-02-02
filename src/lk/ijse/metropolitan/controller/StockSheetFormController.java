package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class StockSheetFormController {
    public AnchorPane paneStockSheet;
    public Label lblDate;
    public TextField txtSID;
    public TextField txtPID;
    public TextField txtBrand;
    public ComboBox txtProType;
    public TextField txtDesc;
    public TextField txtQty;
    public TextField txtPrice;
    public Button btnAdd;
    public TableView tblCart;
    public TableColumn colCode;
    public TableColumn colType;
    public TableColumn colBrand;
    public TableColumn colDesc;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableColumn colDel;
    public Button btnStock;
    public ComboBox cmpSupID;

    public void takeStockOnAction(ActionEvent actionEvent) {
    }
}
