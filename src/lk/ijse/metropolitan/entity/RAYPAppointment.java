package lk.ijse.metropolitan.entity;

import java.sql.Date;

public class RAYPAppointment {
    private String rId;
    private String customer;
    private Date callDate;
    private Date appointmentDate;
    private String description;
    private String appointedEmp;

    public RAYPAppointment() {
    }

    public RAYPAppointment(String rId, String customer, Date callDate, Date appointmentDate, String description, String appointedEmp) {
        this.rId = rId;
        this.customer = customer;
        this.callDate = callDate;
        this.appointmentDate = appointmentDate;
        this.description = description;
        this.appointedEmp = appointedEmp;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppointedEmp() {
        return appointedEmp;
    }

    public void setAppointedEmp(String appointedEmp) {
        this.appointedEmp = appointedEmp;
    }

    @Override
    public String toString() {
        return "RAYPAppointment{" +
                "rId='" + rId + '\'' +
                ", customer='" + customer + '\'' +
                ", callDate=" + callDate +
                ", appointmentDate=" + appointmentDate +
                ", description='" + description + '\'' +
                ", appointedEmp='" + appointedEmp + '\'' +
                '}';
    }
}
