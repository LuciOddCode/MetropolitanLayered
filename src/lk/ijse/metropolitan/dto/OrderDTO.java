package lk.ijse.metropolitan.dto;

import java.time.LocalDate;

public class OrderDTO {
    private String oId;
    private String cId;
    private LocalDate orderDate;
    private double total;

    public OrderDTO() {

    }

    public OrderDTO(String oId, String cId, LocalDate orderDate, double total) {
        this.oId = oId;
        this.cId = cId;
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
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
        return "OrderDTO{" +
                "oId='" + oId + '\'' +
                ", cId='" + cId + '\'' +
                ", orderDate=" + orderDate +
                ", total=" + total +
                '}';
    }
}
