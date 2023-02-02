package lk.ijse.metropolitan.bo;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {



        private static AnchorPane pane;
        public static void navigate(Routes routes, AnchorPane pane) throws IOException {
            Navigation.pane=pane;
            Navigation.pane.getChildren().clear();

            Stage window = (Stage) Navigation.pane.getScene().getWindow();

            switch(routes){
                case LOGIN:
                    window.setTitle("Login Form");
                    initUI("LoginForm.fxml");
                    break;
                case DASHBOARD:
                    window.setTitle("Dashboard Form");
                    initUI("DashboardForm.fxml");
                    break;
                case SALARY:
                    window.setTitle("Salary Form");
                    initUI("SalaryForm.fxml");
                    break;
                case SIGNUP:
                    window.setTitle("Sign Up");
                    initUI("SignUpForm.fxml");
                    break;
                case PAYMENT:
                    window.setTitle("RAYP Payments");
                    initUI("RAYPPaymentForm.fxml");
                    break;
                case PRODUCT:
                    window.setTitle("ItemForm");
                    initUI("ProductForm.fxml");
                    break;
                case CUSTOMER:
                    window.setTitle("Customer Form");
                    initUI("CustomerForm.fxml");
                    break;
                case EMPLOYEE:
                    window.setTitle("Employee Form");
                    initUI("EmployeeForm.fxml");
                    break;
                case SUPPLIER:
                    window.setTitle("Supplier Form");
                    initUI("SupplierForm.fxml");
                    break;
                case CHECK_OUT:
                    window.setTitle("Check Out Form");
                    initUI("CheckOutForm.fxml");
                    break;
                case STOCKSHEET:
                    window.setTitle("Stock Sheet Form");
                    initUI("StockSheetForm.fxml");
                    break;
                case REAPPOINTMENT:
                    window.setTitle("RAYP Appointment Form");
                    initUI("RAYPAppForm.fxml");
                    break;
                case INCOMEREPORT:
                    window.setTitle("Income Report");
                    initUI("IncomeReportForm.fxml");
                    break;
                default:
                    window.setTitle("Login Form");
                    initUI("LoginForm.fxml");
                    break;
            }
        }

        private static void initUI(String location) throws IOException {
            Navigation.pane.getChildren().add(FXMLLoader
                    .load(Navigation.class.getResource("/lk/ijse/metropolitan/view/" + location)));
        }

}
