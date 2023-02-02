package lk.ijse.metropolitan.entity;

import java.sql.Date;

public class Supplier {
    private Date arrDate;
    private String sId;
    private String company;
    private String email;
    private String phone;

    public Supplier() {
    }

    public Supplier(Date arrDate, String sId, String company, String email, String phone) {
        this.arrDate = arrDate;
        this.sId = sId;
        this.company = company;
        this.email = email;
        this.phone = phone;
    }

    public Date getArrDate() {
        return arrDate;
    }

    public void setArrDate(Date arrDate) {
        this.arrDate = arrDate;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "arrDate=" + arrDate +
                ", sId='" + sId + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
