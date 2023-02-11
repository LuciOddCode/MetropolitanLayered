package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.SignUpBO;

public class SignUpFormController {
    public AnchorPane paneUser;
    public TextField txtEID;
    public TextField txtUserName;
    public TextField txtDesignation;
    public Button btnSave;
    public Button btnClear;
    public TableView tblCustomer;
    public TableView tblUsers;
    public TableColumn colEid;
    public TableColumn colUName;
    public TableColumn colDesignation;
    public TableColumn colDelete;
    public TextField txtSearch;
    public PasswordField txtPassword;
    public PasswordField txtRePass;

    SignUpBO signUpBO = (SignUpBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SIGN_UP);

    public void saveOnAction(ActionEvent actionEvent) {
    }
}
