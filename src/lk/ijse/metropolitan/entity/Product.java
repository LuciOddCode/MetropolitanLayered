package lk.ijse.metropolitan.entity;

public class Product {
    private String prId;
    private String type;
    private String brand;
    private String description;
    private double buyingPrice;
    private double sellingPrice;
    private double qtyOnHand;

    public Product() {
    }

    public Product(String prId, String type, String brand, String description, double buyingPrice, double sellingPrice, double qtyOnHand) {
        this.prId = prId;
        this.type = type;
        this.brand = brand;
        this.description = description;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
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

    public double getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(double qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prId='" + prId + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", buyingPrice=" + buyingPrice +
                ", sellingPrice=" + sellingPrice +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
