package lk.ijse.metropolitan.dto;

public class OrderDetailDTO {
    private String oId;
    private String prId;
    private String type;
    private String brand;
    private String description;
    private double qty;
    private double unitPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String oId, String prId, String type, String brand, String description, double qty, double unitPrice) {
        this.oId = oId;
        this.prId = prId;
        this.type = type;
        this.brand = brand;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
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

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "oId='" + oId + '\'' +
                ", prId='" + prId + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
