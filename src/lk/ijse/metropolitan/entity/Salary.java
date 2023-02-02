package lk.ijse.metropolitan.entity;

public class Salary {
    private String slId;
    private String month;
    private String eId;
    private String designation;
    private double salary;

    public Salary() {
    }

    public Salary(String slId, String month, String eId, String designation, double salary) {
        this.slId = slId;
        this.month = month;
        this.eId = eId;
        this.designation = designation;
        this.salary = salary;
    }

    public String getSlId() {
        return slId;
    }

    public void setSlId(String slId) {
        this.slId = slId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
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

    @Override
    public String toString() {
        return "Salary{" +
                "slId='" + slId + '\'' +
                ", month='" + month + '\'' +
                ", eId='" + eId + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
