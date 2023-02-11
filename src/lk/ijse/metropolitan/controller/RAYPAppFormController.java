package lk.ijse.metropolitan.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.EmployeeBO;
import lk.ijse.metropolitan.bo.custom.RAYPAppBO;
import lk.ijse.metropolitan.view.tm.RAYPAppTM;


import java.sql.Date;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;

public class RAYPAppFormController {

    public AnchorPane paneAppoint;
    public TextField txtRID;
    public TextField txtCID;
    public ComboBox cmbEmployee;
    public DatePicker dateCall;
    public DatePicker dateRepair;
    public TableView<RAYPAppTM> tblRAPApp;
    public TableColumn colRID;
    public TableColumn colCID;
    public TableColumn colCallDate;
    public TableColumn colRepDate;
    public TableColumn colDesc;
    public TableColumn colEID;
    public TableColumn colDelete;
    public Button btnAdd;
    public Button btnClear;
    public TextField txtDescription;

    RAYPAppBO raypAppBO = (RAYPAppBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RAYPA);
    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    public void initialize() throws SQLException, ClassNotFoundException {
        colRID.setCellValueFactory(new PropertyValueFactory<>("rId"));
        colCID.setCellValueFactory(new PropertyValueFactory<>("customer"));
        colCallDate.setCellValueFactory(new PropertyValueFactory<>("callDate"));
        colRepDate.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colEID.setCellValueFactory(new PropertyValueFactory<>("appointedEmp"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
        cmbEmployee.setStyle("-fx-text-fill: white; ");

        loadEmployees();
        loadAllAppointments();
    }

    private void initUI() {
        txtRID.clear();
        txtCID.clear();
        txtDescription.clear();

        txtRID.setDisable(true);
        txtCID.setDisable(true);
        cmbEmployee.setDisable(true);
        dateCall.setDisable(true);
        dateRepair.setDisable(true);
        txtDescription.setDisable(true);

        btnClear.setDisable(true);
    }

    private void loadAllAppointments() throws SQLException, ClassNotFoundException {
        ObservableList raypAppointmentTMS = raypAppBO.getAllApp();
        tblRAPApp.setItems(raypAppointmentTMS);
    }

    private void loadEmployees() throws SQLException, ClassNotFoundException {

        ObservableList<String> employeeIDList = FXCollections.observableArrayList();
        ArrayList allEmps = employeeBO.getAllEmp();
        cmbEmployee.setItems(employeeIDList);
    }

    public void cidOnAction(ActionEvent actionEvent) {

    }

    public void eIdOnAction(ActionEvent actionEvent) {
    }

    public void addOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {/*
        //variables to save data from text fields
        String rId = txtRID.getText();
        String cId = txtCID.getText();
        String eId = (String) cmbEmployee.getValue();
        java.util.Date dateC = java.util.Date.from(dateCall.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date callDate = new Date(dateC.getTime());
        java.util.Date dateR = java.util.Date.from(dateRepair.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date repairDate = new Date(dateR.getTime());
        String description = txtDescription.getText();

        RAYPAppointment raypAppointment = new RAYPAppointment(rId, cId, callDate, repairDate, description, eId);

        boolean isAdded = RAYPAppointmentModel.saveAppointment(raypAppointment);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Appointment Scheduled Successfully").show();
            txtRID.setText(FrequentNeeds.nextID(Tables.RAYP));
            txtCID.setText(null);
            txtDescription.setText(null);

        } else {
            new Alert(Alert.AlertType.INFORMATION, "Appointment scheduling Failed").show();
        }*/
    }

    public void clearOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       /* txtRID.setText(FrequentNeeds.nextID(Tables.RAYP));
        txtCID.setText(null);
        txtDescription.setText(null);*/
    }

    public void addAppOnAction(ActionEvent actionEvent) {
        btnAdd.fire();
    }
}
