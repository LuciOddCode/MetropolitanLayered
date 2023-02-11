package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.RAYPPaymentBO;

import java.sql.SQLException;

public class RAYPPaymentFormController {
    public AnchorPane panePayment;
    public Label lblDate;
    public Button btnPayment;
    public TextField txtPID;
    public TextField txtOID;
    public TextField txtAppID;
    public TextField txtCost;
    public ComboBox cmbGivenBY;
    public DatePicker datePaymentDate;

    RAYPPaymentBO raypPaymentBO = (RAYPPaymentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RAYPP);

    public void initialize() throws SQLException, ClassNotFoundException {
      /*  txtPID.setText(FrequentNeeds.nextID(Tables.RAYPP));
        txtAppID.requestFocus();
        lblDate.setText("Date : "+ LocalDate.now());
        loadEmployee();*/
    }

    private void loadEmployee() throws SQLException, ClassNotFoundException {
       /* String sql = "SELECT eId FROM employee";
        ResultSet resultSet = CrudUtil.execute(sql);
        ObservableList<String> employeeIDList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            employeeIDList.add(resultSet.getString(1));
        }
        cmbGivenBY.setItems(employeeIDList);*/
    }

    public void doPayment(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {/*
        String pId=txtPID.getText();
        String appId=txtAppID.getText();

        java.util.Date date = java.util.Date.from(datePaymentDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date paymentDate = new java.sql.Date(date.getTime());

        double cost = Double.parseDouble(txtCost.getText());
        String givenBy= String.valueOf(cmbGivenBY.getValue());
        Payment payment = new Payment(pId,appId,paymentDate,cost,givenBy);
        boolean isAdded = RAYPPaymentModel.addPayment(payment);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Payment Added").show();
            txtPID.setText(null);
            txtCost.setText("0");
            txtAppID.setText(null);
            txtAppID.requestFocus();
        }else{
            new Alert(Alert.AlertType.WARNING,"Payment Failed").show();
        }*/
    }
}
