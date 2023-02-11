package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.StockSheetBO;
import lk.ijse.metropolitan.bo.custom.impl.StockSheetBOImpl;

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

    StockSheetBO stockSheetBO = (StockSheetBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SS);

    public void takeStockOnAction(ActionEvent actionEvent) {

    }
}
