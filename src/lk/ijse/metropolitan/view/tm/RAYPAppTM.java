package lk.ijse.metropolitan.view.tm;

import javafx.scene.control.Button;

import java.time.LocalDate;

public class RAYPAppTM {
    private String rId;
    private String cId;
    private LocalDate callDate;
    private LocalDate appDate;
    private String description;
    private String eId;
    private Button delete;

    public RAYPAppTM() {
    }

    public RAYPAppTM(String rId, String cId, LocalDate callDate, LocalDate appDate, String description, String eId, Button delete) {
        this.rId = rId;
        this.cId = cId;
        this.callDate = callDate;
        this.appDate = appDate;
        this.description = description;
        this.eId = eId;
        this.delete = delete;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public LocalDate getCallDate() {
        return callDate;
    }

    public void setCallDate(LocalDate callDate) {
        this.callDate = callDate;
    }

    public LocalDate getAppDate() {
        return appDate;
    }

    public void setAppDate(LocalDate appDate) {
        this.appDate = appDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "RAYPAppTM{" +
                "rId='" + rId + '\'' +
                ", cId='" + cId + '\'' +
                ", callDate=" + callDate +
                ", appDate=" + appDate +
                ", description='" + description + '\'' +
                ", eId='" + eId + '\'' +
                ", delete=" + delete +
                '}';
    }
}
