package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.SupplierBO;
import lk.ijse.metropolitan.view.tm.SupplierTM;


import java.sql.SQLException;

public class SupplierFormController {
    public AnchorPane paneSupplier;
    public TextField txtCID;
    public TextField txtName;
    public TextField txtMail;
    public TextField txtPhone;
    public Button btnSave;
    public Button btnClear;
    public TableView<SupplierTM> tblSupplier;
    public TableColumn colSID;
    public TableColumn colComName;
    public TableColumn colMail;
    public TableColumn colPhone;
    public TableColumn colDate;
    public TableColumn colDelete;
    public TextField txtSearch;
    public TextField txtsId;
    public TextField txtCompanyName;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);

    public void initialize() throws SQLException, ClassNotFoundException {
        colSID.setCellValueFactory(new PropertyValueFactory<>("sId"));
        colComName.setCellValueFactory(new PropertyValueFactory<>("company"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("arrDate"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        loadAllSuppliers();


    }

    private void loadAllSuppliers() throws SQLException, ClassNotFoundException {
        colDate.setCellValueFactory(new PropertyValueFactory<>("arrDate"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("arrDate"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("arrDate"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("arrDate"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("arrDate"));
        // ObservableList supplier = SupplierModel.addToTable(tblSupplier);
        // tblSupplier.setItems(supplier);
    }


    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {/*
        Date arrDate= Date.valueOf(LocalDate.now());
        String sId = txtsId.getText();
        String company = txtCompanyName.getText();
        String email = txtMail.getText();
        String phone = txtPhone.getText();

        Supplier supplier = new Supplier(arrDate,sId,company,email,phone);
        boolean isAdded = SupplierModel.addSupplier(supplier);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Supplier Added Successfully").show();
            txtsId.setText(FrequentNeeds.nextID(Tables.SUPPLIER));
            txtPhone.setText(null);
            txtCompanyName.setText(null);
            txtMail.setText(null);
            tblSupplier.refresh();
        }else{
            new Alert(Alert.AlertType.WARNING,"Supplier Adding Failed").show();
        }

*/
    }

    public void sidOnAction(ActionEvent actionEvent) {
    }

    public void cmpNameOnAction(ActionEvent actionEvent) {
    }

    public void mailOnAction(ActionEvent actionEvent) {
    }

    public void phoneOnAction(ActionEvent actionEvent) {
    }

    public void clearOnAction(ActionEvent actionEvent) {
    }
}
