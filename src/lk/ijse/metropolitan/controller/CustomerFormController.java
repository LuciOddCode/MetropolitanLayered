package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.CustomerBO;
import lk.ijse.metropolitan.dto.CustomerDTO;
import lk.ijse.metropolitan.view.tm.CustomerTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerFormController {
    public TextField txtCID;
    public TextField txtName;
    public TextField txtMail;
    public TextField txtAddress;
    public TextField txtPhone;
    public TextField txtEID;
    public Button btnSave;
    public Button btnClear;
    public TableView<CustomerTM> tblCustomer;
    public TableColumn cid;
    public TableColumn name;
    public TableColumn email;
    public TableColumn address;
    public TableColumn phone;
    public TableColumn delete;
    public TextField txtSearch;
    public AnchorPane pane;
    public AnchorPane paneCustomer;

    //DI USING BOFACTORY

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);


    @FXML
    public void initialize() {
        cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        btnSave.setText("Add");

        loadAllCustomer();
        initUI();

    }


    private void initUI() {
        txtCID.clear();
        txtName.clear();
        txtAddress.clear();
        txtPhone.clear();
        txtMail.clear();

        txtCID.setDisable(true);
        txtName.setDisable(true);
        txtAddress.setDisable(true);
        txtPhone.setDisable(true);
        txtMail.setDisable(true);
        btnClear.setDisable(true);

    }


    private void loadAllCustomer() {
        tblCustomer.getItems().clear();
        try {
            /*Get all customers*/
            ArrayList<CustomerDTO> allCustomers = customerBO.getAllCustomers();

            for (CustomerDTO c : allCustomers) {
                tblCustomer.getItems().add(new CustomerTM(c.getcId(), c.getName(), c.getEmail(), c.getAddress(), c.getPhone()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }


    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        if (btnSave.getText().equalsIgnoreCase("Add")) {

            btnSave.setText("Save");
            txtCID.setText(customerBO.generateNextId());
            txtCID.setDisable(false);
            txtName.setDisable(false);
            txtAddress.setDisable(false);
            txtPhone.setDisable(false);
            txtMail.setDisable(false);
            btnClear.setDisable(false);




        } else if (btnSave.getText().equalsIgnoreCase("Update")){

            boolean isUpdate = false;
            try {
                //variables to save data from text fields
                String cId = txtCID.getText();
                String name = txtName.getText();
                String address = txtAddress.getText();
                String email = txtMail.getText();
                String phone = txtPhone.getText();
                String eId = LoginFormController.currentUser;

                CustomerDTO customer = new CustomerDTO(cId, name, email, address, phone, eId);
                isUpdate = customerBO.updateCus(customer);
                if (isUpdate) {
                    new Alert(Alert.AlertType.INFORMATION, "Customer Updated Successfully").show();
                    btnSave.setText("Add");
                    initUI();
                    tblCustomer.refresh();
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Customer Adding Failed").show();
                    btnSave.setText("Add");
                    initUI();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }else if (btnSave.getText().equalsIgnoreCase("Save")){
            //variables to save data from text fields
            String cId = txtCID.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String email = txtMail.getText();
            String phone = txtPhone.getText();
            String eId = LoginFormController.currentUser;

            CustomerDTO customer = new CustomerDTO(cId, name, email, address, phone, eId);
            boolean isAdded = customerBO.addCustomer(customer);
            if (isAdded && btnSave.getText().equalsIgnoreCase("Save")) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Added Successfully").show();
                btnSave.setText("Add");
                initUI();
                tblCustomer.getItems().add(new CustomerTM(cId, name, email, address, phone));
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Customer Adding Failed").show();
                btnSave.setText("Add");
                initUI();
            }
        }

    }

    public void searchOnChanges(InputMethodEvent inputMethodEvent) {

    }

    public void cidOnAction(ActionEvent actionEvent) {
        txtName.requestFocus();
    }

    public void nameOnAction(ActionEvent actionEvent) {
        txtMail.requestFocus();
    }

    public void emailOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void addressOnAction(ActionEvent actionEvent) {
        txtPhone.requestFocus();
    }

    public void saveCustOnAction(ActionEvent actionEvent) {
        btnSave.fire();
        tblCustomer.refresh();
        initUI();
        txtName.requestFocus();
    }

    public void clearOnAction(ActionEvent actionEvent) {
        if (btnClear.getText().equals("Delete")) {
            boolean isDeleted = false;
            try {
                isDeleted = customerBO.deleteCus(txtCID.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Deleted Successfully");
                btnSave.setText("Add");
                btnClear.setText("Clear");
                initUI();
                tblCustomer.refresh();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Customer Deletion failed");
                btnSave.setText("Add");
                btnClear.setText("Clear");
                initUI();
                tblCustomer.refresh();
            }
        } else {
            try {
                txtCID.setText(customerBO.generateNextId());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            txtPhone.setText(null);
            txtMail.setText(null);
            txtAddress.setText(null);
            txtName.setText(null);
        }


    }

    public void searchOnAction(ActionEvent actionEvent) {
        boolean isExists = false;
        try {
            isExists = customerBO.existsCus(txtSearch.getText());
            if (isExists) {
                CustomerDTO customerDTO = customerBO.searchCus(txtSearch.getText());
                btnSave.setText("Update");
                btnClear.setText("Delete");

                txtCID.setDisable(false);
                txtName.setDisable(false);
                txtAddress.setDisable(false);
                txtPhone.setDisable(false);
                txtMail.setDisable(false);

                txtCID.setText(customerDTO.getcId());
                txtName.setText(customerDTO.getName());
                txtPhone.setText(customerDTO.getPhone());
                txtAddress.setText(customerDTO.getAddress());
                txtMail.setText(customerDTO.getEmail());

                btnClear.setDisable(false);
                btnSave.setDisable(false);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
