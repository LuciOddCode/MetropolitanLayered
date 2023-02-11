package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.SalaryBO;

import java.sql.SQLException;

public class SalaryFormController {
    public AnchorPane paneSalary;
    public TextField txtSalID;
    public TextField txtDesignation;
    public TextField txtSalary;
    public Button btnSave;
    public Button btnClear;
    public TableView tblSalary;
    public TableColumn cloSalID;
    public TableColumn colEID;
    public TableColumn colSalDate;
    public TableColumn colDesignation;
    public TableColumn colSalary;
    public TableColumn colDelete;
    public TextField txtSearch;
    public ComboBox cmbEID;
    public DatePicker dateSalDate;

    SalaryBO salaryBO = (SalaryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SALARY);

    public void initialize() throws SQLException, ClassNotFoundException {
        loadEmployeeIds();
    }

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {/*
        //variables to save data from text fields
        String sId = txtSalID.getText();
        String eId = (String) cmbEID.getValue();
        java.util.Date date = java.util.Date.from(dateSalDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date salDate = new java.sql.Date(date.getTime());
        String designation = txtDesignation.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        Salary salaryCl = new Salary(sId, eId, salDate, designation, salary);

        boolean isAdded = SalaryModel.saveSalary(salaryCl);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Employee Salary Added Successfully").show();
            txtSalID.setText(FrequentNeeds.nextID(Tables.SALARY));
            dateSalDate.setValue(null);
            txtDesignation.setText(null);
            txtSalary.setText(null);

        } else {
            new Alert(Alert.AlertType.INFORMATION, "Employee Salary Adding Failed").show();
        }*/
    }

    private void loadEmployeeIds() throws SQLException, ClassNotFoundException {/*
        ObservableList<String> observableList = FXCollections.observableArrayList();
        ArrayList<String> idList = EmployeeModel.loadEmployeeIds();

        for (String id : idList) {
            observableList.add(id);
        }
        cmbEID.setItems(observableList);*/
    }
}
