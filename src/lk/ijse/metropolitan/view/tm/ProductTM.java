package lk.ijse.metropolitan.view.tm;

import javafx.scene.control.Button;

public class ProductTM {
    private String pId;
    private String type;
    private String brand;
    private String description;
    private double qtyOnHand;
    private double buyingPrice;
    private double sellingPrice;


    public ProductTM() {
    }

    public ProductTM(String pId, String type, String brand, String description, double qtyOnHand, double buyingPrice, double sellingPrice) {
        this.pId = pId;
        this.type = type;
        this.brand = brand;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;

    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(double qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }


    @Override
    public String toString() {
        return "ProductTM{" +
                "pId='" + pId + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                ", buyingPrice=" + buyingPrice +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
