package lk.ijse.metropolitan.dto;

import java.sql.Date;
import java.time.LocalDate;

public class EmployeeDTO {
    private String eId;
    private String name;
    private String phone;
    private LocalDate DOB;
    private String mail;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String eId, String name, String phone, LocalDate DOB, String mail) {
        this.eId = eId;
        this.name = name;
        this.phone = phone;
        this.DOB = DOB;
        this.mail = mail;
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

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "eId='" + eId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", DOB=" + DOB +
                ", mail='" + mail + '\'' +
                '}';
    }
}
