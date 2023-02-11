package lk.ijse.metropolitan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.custom.IncomeReportBO;

public class IncomeReportFormController {
    public Button btnDaily;
    public Button btnMonthly;
    public Button btnYearly;
    public AnchorPane paneReport;

    IncomeReportBO incomeReportBO = (IncomeReportBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.IR);

    public void dailyReportOnAction(ActionEvent actionEvent) {
    }

    public void yearyReportOnAction(ActionEvent actionEvent) {
    }

    public void monthlyReportOnAction(ActionEvent actionEvent) {
    }
}
