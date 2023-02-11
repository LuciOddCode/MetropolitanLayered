package lk.ijse.metropolitan.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.EmployeeBO;
import lk.ijse.metropolitan.dto.CustomerDTO;
import lk.ijse.metropolitan.dto.EmployeeDTO;
import lk.ijse.metropolitan.view.tm.CustomerTM;
import lk.ijse.metropolitan.view.tm.EmployeeTM;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeFormController {

    public AnchorPane pane;
    public TextField txtName;
    public TextField txtMail;
    public TextField txtPhone;
    public Button btnSave;
    public Button btnClear;
    public TextField txtSearch;
    public DatePicker dateDOB;
    public TableView<EmployeeTM> tblEmployee;
    public TextField txtEID;
    public TableColumn colEid;
    public TableColumn colName;
    public TableColumn colPhone;
    public TableColumn colDOB;
    public TableColumn colEmail;
    public TableColumn colDelete;
    public TextField txtSearchRight;

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);


    public void initialize() {

        try {
            txtEID.setText(employeeBO.generateNextEID());
            colEid.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

            btnSave.setText("Add");

            loadAllEmployee();
            initUI();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void initUI() {
        txtEID.clear();
        txtName.clear();
        txtMail.clear();
        txtPhone.clear();

        txtEID.setDisable(true);
        txtName.setDisable(true);

        txtPhone.setDisable(true);
        txtMail.setDisable(true);
        btnClear.setDisable(true);
    }

    private void loadAllEmployee() {
        try {
            /*Get all customers*/
            ArrayList<EmployeeDTO> allEmployee = employeeBO.getAllEmp();

            for (EmployeeDTO e : allEmployee) {
                tblEmployee.getItems().add(new EmployeeTM(e.geteId(),e.getName(),e.getPhone(),e.getDOB().toString(),e.getMail()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void saveOnAction(ActionEvent actionEvent) {

        txtEID.setDisable(false);
        txtName.setDisable(false);
        txtPhone.setDisable(false);
        txtMail.setDisable(false);
        btnClear.setDisable(false);
        if (btnSave.getText().equals("Add")) {
            try {
                txtEID.setText(employeeBO.generateNextEID());
                btnSave.setText("Save");
                //variables to save data from text fields

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else if (btnSave.getText().equalsIgnoreCase("Update")){

            boolean isUpdate = false;
            try {
                //variables to save data from text fields
                String cId = txtEID.getText();
                String name = txtName.getText();
                LocalDate dob = dateDOB.getValue();
                String email = txtMail.getText();
                String phone = txtPhone.getText();

                EmployeeDTO employeeDTO = new EmployeeDTO(cId, name, phone, dob,email);
                isUpdate = employeeBO.updateEmp(employeeDTO);
                if (isUpdate) {
                    new Alert(Alert.AlertType.INFORMATION, "Employee Updated Successfully").show();
                    btnSave.setText("Add");
                    initUI();
                    tblEmployee.refresh();
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Employee Adding Failed").show();
                    btnSave.setText("Add");
                    initUI();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }else if (btnSave.getText().equalsIgnoreCase("Save")){
            String cId = txtEID.getText();
            String name = txtName.getText();
            LocalDate dob = dateDOB.getValue();
            String email = txtMail.getText();
            String phone = txtPhone.getText();

            EmployeeDTO employee = new EmployeeDTO(cId, name, phone,dob, email);
            boolean isAdded = false;
            try {
                isAdded = employeeBO.saveEmp(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (isAdded) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Added Successfully").show();
                btnSave.setText("Add");
                initUI();
                tblEmployee.getItems().add(new EmployeeTM(cId, name, phone, dob.toString(), email));
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Employee Adding Failed").show();
                btnSave.setText("Add");
                initUI();
            }
        }

    }

    public void searchOnChanges(InputMethodEvent inputMethodEvent) {

    }


    public void checkIfExists(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
        try {
            boolean isExists = employeeBO.exists(txtSearch.getText());
            if (isExists) {
                EmployeeDTO em = employeeBO.searchEmp(txtSearch.getText());
                txtEID.setText(em.geteId());
                txtName.setText(em.getName());
                txtPhone.setText(em.getPhone());
                dateDOB.setValue(em.getDOB());
                txtMail.setText(em.getMail());
            } else {
                new Alert(Alert.AlertType.INFORMATION, "There is no Employee with id - " + txtSearch.getText())
                        .show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void nameEntered(ActionEvent actionEvent) {
        txtMail.requestFocus();
    }

    public void saveOnEnter(ActionEvent actionEvent) {
        btnSave.fire();
        tblEmployee.refresh();
        initUI();
        txtName.requestFocus();

    }

    public void clearOnAction(ActionEvent actionEvent) {

        if (btnClear.getText().equals("Delete")) {
            boolean isDeleted = false;
            try {
                isDeleted = employeeBO.deleteEmp(txtEID.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Deleted Successfully");
                btnSave.setText("Add");
                btnClear.setText("Clear");
                initUI();
                tblEmployee.refresh();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Employee Deletion failed");
                btnSave.setText("Add");
                btnClear.setText("Clear");
                initUI();
            }
        } else {
            try {
                txtEID.setText(employeeBO.generateNextEID());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            txtPhone.setText(null);
            txtMail.setText(null);
            txtName.setText(null);
        }
    }
}
