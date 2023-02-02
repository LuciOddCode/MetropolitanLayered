package lk.ijse.metropolitan.entity;

import java.sql.Date;

public class Orders {
    private String oId;
    private String cId;
    private String uId;
    private Date orderDate;
    private double total;

    public Orders() {
    }

    public Orders(String oId, String cId, String uId, Date orderDate, double total) {
        this.oId = oId;
        this.cId = cId;
        this.uId = uId;
        this.orderDate = orderDate;
        this.total = total;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oId='" + oId + '\'' +
                ", cId='" + cId + '\'' +
                ", uId='" + uId + '\'' +
                ", orderDate=" + orderDate +
                ", total=" + total +
                '}';
    }
}
