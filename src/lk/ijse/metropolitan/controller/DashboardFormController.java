package lk.ijse.metropolitan.controller;

import com.jfoenix.controls.JFXHamburger;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.Navigation;
import lk.ijse.metropolitan.bo.Routes;


import java.io.IOException;

public class DashboardFormController {

    public Button btnHome;
    public Button btnCheckOut;
    public Button btnCust;
    public Button btnItem;
    public Button btnRAYPApp;
    public Button btnIncomeRep;
    public Button btnWarranty;
    public Button btnRAYPPayments;
    public Button btnStockSheet;
    public Button btnEmployee;
    public Button btnPayroll;
    public Button btnSupplier;
    public static Button btnSignUp;
    public Button btnSignOut;
    public AnchorPane paneLoad;
    public PieChart pieChart;
    public AnchorPane paneMain;


    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        paneLoad.getChildren().clear();
        Navigation.navigate(Routes.DASHBOARD,paneMain);

    }

    public void checkOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CHECK_OUT, paneLoad);
    }

    public void customerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CUSTOMER, paneLoad);
    }

    public void itemOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PRODUCT, paneLoad);
    }

    public void appoinmentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.REAPPOINTMENT, paneLoad);
    }

    public void incomeRepOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.INCOMEREPORT, paneLoad);
    }

    public void warrentyOnAction(ActionEvent actionEvent) throws IOException {
        // Navigation.navigate(Routes.,paneLoad);
    }

    public void paymentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENT, paneLoad);
    }

    public void stockOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKSHEET, paneLoad);
    }

    public void employeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE, paneLoad);
    }

    public void payroleOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SALARY, paneLoad);
    }

    public void supplierOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER, paneLoad);
    }

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SIGNUP, paneLoad);
    }

    public void signOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, paneMain);
    }
    public static void setAction(ActionEvent actionEvent){
        btnSignUp.fire();
    }

}
