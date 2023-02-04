package lk.ijse.metropolitan.view.tm;

import javafx.scene.control.Button;

import java.time.LocalDate;

public class EmployeeTM {
    private String eId;
    private String name;
    private String phone;
    private LocalDate dob;
    private String email;
    private Button delete;

    public EmployeeTM() {
    }

    public EmployeeTM(String eId, String name, String phone, LocalDate dob, String email, Button delete) {
        this.eId = eId;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.email = email;
        this.delete = delete;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "EmployeeTM{" +
                "eId='" + eId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", delete=" + delete +
                '}';
    }
}
