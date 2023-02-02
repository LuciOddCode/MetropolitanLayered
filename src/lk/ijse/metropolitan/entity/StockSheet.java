package lk.ijse.metropolitan.entity;

public class StockSheet {
    private String sId;
    private String prId;
    private double qty;
    private double price;

    public StockSheet() {
    }

    public StockSheet(String sId, String prId, double qty, double price) {
        this.sId = sId;
        this.prId = prId;
        this.qty = qty;
        this.price = price;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
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
        return "StockSheet{" +
                "sId='" + sId + '\'' +
                ", prId='" + prId + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
