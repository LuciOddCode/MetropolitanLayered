package lk.ijse.metropolitan.view.tm;

import javafx.scene.control.Button;

import java.time.LocalDate;

public class SalaryTM {
    private String sId;
    private String eId;
    private LocalDate salDate;
    private String designation;
    private double salary;
    private Button delete;

    public SalaryTM(String sId, String eId, LocalDate salDate, String designation, double salary, Button delete) {
        this.sId = sId;
        this.eId = eId;
        this.salDate = salDate;
        this.designation = designation;
        this.salary = salary;
        this.delete = delete;
    }

    public SalaryTM() {
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public LocalDate getSalDate() {
        return salDate;
    }

    public void setSalDate(LocalDate salDate) {
        this.salDate = salDate;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "SalaryTM{" +
                "sId='" + sId + '\'' +
                ", eId='" + eId + '\'' +
                ", salDate=" + salDate +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", delete=" + delete +
                '}';
    }
}
