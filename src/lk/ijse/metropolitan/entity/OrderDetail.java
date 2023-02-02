package lk.ijse.metropolitan.entity;

public class OrderDetail {
    private String oId;
    private String prId;
    private double qty;
    private double price;

    public OrderDetail() {
    }

    public OrderDetail(String oId, String prId, double qty, double price) {
        this.oId = oId;
        this.prId = prId;
        this.qty = qty;
        this.price = price;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "oId='" + oId + '\'' +
                ", prId='" + prId + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
