package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.custom.LoginBO;
import lk.ijse.metropolitan.bo.custom.impl.LoginBOImpl;

public class LoginFormController {
    public AnchorPane paneLogin;
    public TextField txtUName;
    public PasswordField txtPass;
    public Label lblInvalidUN;
    public Label lblInvalidPass;
    public Button btnLogin;
    public ImageView whatsappIcon;
    public ImageView fbIcon;
    public ImageView instaIcon;
    public Button btnSignUp;
    boolean isValidUser;
    boolean isValidPass;
    LoginBO loginBO = new LoginBOImpl();


    public void validateUsernameOnAction(ActionEvent actionEvent) {
        isValidUser = loginBO.validateUserName(txtUName.getText());
    }

    public void validatePasswordOnAction(ActionEvent actionEvent) {
        if (isValidUser)
            isValidPass = loginBO.validatePassword(txtPass.getText());
    }

    public void loginOnAction(ActionEvent actionEvent) {
    }

    public void signUpAction(ActionEvent actionEvent) {
    }

    public void usernameChanged(InputMethodEvent inputMethodEvent) {
    }

    public void passwordChanged(InputMethodEvent inputMethodEvent) {
    }

    public void colourOnMouseEnter(MouseEvent mouseEvent) {
    }

    public void fbOnAction(MouseEvent mouseEvent) {
    }

    public void whatsappOnAction(MouseEvent mouseEvent) {
    }

    public void instaOnAction(MouseEvent mouseEvent) {
    }
}
