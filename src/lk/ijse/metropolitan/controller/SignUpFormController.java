package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class SignUpFormController {
    public AnchorPane paneUser;
    public TextField txtEID;
    public TextField txtUserName;
    public TextField txtDesignation;
    public Button btnSave;
    public Button btnClear;
    public TableView tblUsers;
    public TableColumn colEid;
    public TableColumn colUName;
    public TableColumn colDesignation;
    public TableColumn colDelete;
    public TextField txtSearch;
    public PasswordField txtPassword;
    public PasswordField txtRePass;

    public void saveOnAction(ActionEvent actionEvent) {
    }
}
