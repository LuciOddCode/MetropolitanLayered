package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.Navigation;
import lk.ijse.metropolitan.bo.Routes;
import lk.ijse.metropolitan.bo.custom.LoginBO;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public Label lblUserNameAlert;
    public Button btnSignUp;
    public Button btnLogin;
    public PasswordField txtPassword;
    public TextField txtUserName;
    public Label lblPasswordAlert;
    public TextField txtUName;
    public AnchorPane paneLogin;
    public PasswordField txtPass;
    public Label lblInvalidUN;
    public Label lblInvalidPass;
    public ImageView fbIcon;
    public ImageView whatsappIcon;
    public ImageView instaIcon;
    String checkUserName;
    boolean checkPassWord;
    public static String currentUser;

    LoginBO loginBO = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.LOGIN);


    public void loginOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        String username = txtUName.getText();
        String password = txtPass.getText();

        checkPassWord = loginBO.validatePassword(username, password);
        if (!checkPassWord) {
            new Alert(Alert.AlertType.WARNING, "Enter Valid Credentials").show();
            txtPass.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            txtUName.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");

        } else {
            Navigation.navigate(Routes.DASHBOARD, paneLogin);
        }


    }


    public void colourOnMouseEnter(MouseEvent mouseEvent) {

    }


    public void validateUsernameOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String username = txtUName.getText();
        checkUserName = loginBO.validateUsername(username);
        if (checkUserName.equals("red")) {
            new Alert(Alert.AlertType.WARNING, "Enter Valid Username").show();
            txtUName.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
        } else if (checkUserName.equals(txtUName.getText())) {
            txtUName.setStyle("-fx-border-color: #01f5ff ; -fx-border-width: 2px ;");
            txtPass.requestFocus();
        }
    }

    public void validatePasswordOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        String password = txtPass.getText();
        checkPassWord = loginBO.validatePassword(txtUName.getText(), password);
        if (!checkPassWord) {
            new Alert(Alert.AlertType.WARNING, "Password Did not matched").show();
            txtPass.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
        } else {
            txtPass.setStyle("-fx-border-color: #01f5ff ; -fx-border-width: 2px ;");
            btnLogin.fire();
        }
    }


    public void usernameChanged(InputMethodEvent inputMethodEvent) {
        txtUName.setOnInputMethodTextChanged(actionEvent -> txtUName
                .setStyle("fx-border-color: linear-gradient(to right bottom , #17A9FF, #c606ff);"));
    }

    public void passwordChanged(InputMethodEvent inputMethodEvent) {
        txtPass.setOnInputMethodTextChanged(actionEvent -> txtUName
                .setStyle("fx-border-color: linear-gradient(to right bottom , #17A9FF, #c606ff);"));
    }

    public void signUpAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        boolean isValid = loginBO.validatePassword(txtUName.getText(), txtPass.getText());
        if (isValid){
            Navigation.navigate(Routes.DASHBOARD,paneLogin);
            DashboardFormController.setAction(actionEvent);
        }else{
            new Alert(Alert.AlertType.WARNING,"Enter Valid Credentials").show();
        }
            new Alert(Alert.AlertType.ERROR,"Navigation Error Please Contact Developer.").show();
    }

    public void fbOnAction(MouseEvent mouseEvent) {
        //to open fb page of the shop
    }

    public void whatsappOnAction(MouseEvent mouseEvent) {
        //to open WA page of the shop

    }

    public void instaOnAction(MouseEvent mouseEvent) {
        //to open Insta page of the shop

    }
}
