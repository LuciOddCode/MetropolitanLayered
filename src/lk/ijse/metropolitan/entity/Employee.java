package lk.ijse.metropolitan.entity;

import java.sql.Date;

public class Employee {
    private String eId;
    private String name;
    private String phone;
    private Date DOB;
    private String email;

    public Employee() {
    }

    public Employee(String eId, String name, String phone, Date DOB, String email) {
        this.eId = eId;
        this.name = name;
        this.phone = phone;
        this.DOB = DOB;
        this.email = email;
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

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId='" + eId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", DOB=" + DOB +
                ", email='" + email + '\'' +
                '}';
    }
}
