package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class EmployeeFormController {
    public AnchorPane pane;
    public TextField txtEID;
    public TextField txtName;
    public TextField txtMail;
    public TextField txtPhone;
    public Button btnSave;
    public Button btnClear;
    public TableView tblEmployee;
    public TableColumn colEid;
    public TableColumn colName;
    public TableColumn colPhone;
    public TableColumn colDOB;
    public TableColumn colEmail;
    public TableColumn colDelete;
    public TextField txtSearch;
    public DatePicker dateDOB;

    public void saveOnAction(ActionEvent actionEvent) {
    }

}
