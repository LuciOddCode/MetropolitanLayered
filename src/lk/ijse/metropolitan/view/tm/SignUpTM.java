package lk.ijse.metropolitan.view.tm;

import javafx.scene.control.Button;

public class SignUpTM {
    private String eId;
    private String username;
    private String designation;
    private Button delete;

    public SignUpTM() {
    }

    public SignUpTM(String eId, String username, String designation, Button delete) {
        this.eId = eId;
        this.username = username;
        this.designation = designation;
        this.delete = delete;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "SignUpTM{" +
                "eId='" + eId + '\'' +
                ", username='" + username + '\'' +
                ", designation='" + designation + '\'' +
                ", delete=" + delete +
                '}';
    }
}
