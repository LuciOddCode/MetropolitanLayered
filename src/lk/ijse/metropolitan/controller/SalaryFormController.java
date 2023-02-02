package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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

    public void saveOnAction(ActionEvent actionEvent) {
    }
}
