package lk.ijse.metropolitan.entity;


import java.sql.Date;

public class Payment {
    private String pId;
    private String appId;
    private Date paymentDate;
    private double cost;
    private String givenBy;

    public Payment() {
    }

    public Payment(String pId, String appId, Date paymentDate, double cost, String givenBy) {
        this.pId = pId;
        this.appId = appId;
        this.paymentDate = paymentDate;
        this.cost = cost;
        this.givenBy = givenBy;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "pId='" + pId + '\'' +
                ", appId='" + appId + '\'' +
                ", paymentDate=" + paymentDate +
                ", cost=" + cost +
                ", givenBy='" + givenBy + '\'' +
                '}';
    }
}
