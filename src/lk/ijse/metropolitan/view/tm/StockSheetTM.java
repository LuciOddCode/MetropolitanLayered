package lk.ijse.metropolitan.view.tm;

import javafx.scene.control.Button;

public class StockSheetTM {
    private String code;
    private String type;
    private String brand;
    private String description;
    private double qty;
    private double price;
    private Button delete;

    public StockSheetTM() {
    }

    public StockSheetTM(String code, String type, String brand, String description, double qty, double price, Button delete) {
        this.code = code;
        this.type = type;
        this.brand = brand;
        this.description = description;
        this.qty = qty;
        this.price = price;
        this.delete = delete;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "StockSheetTM{" +
                "code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", delete=" + delete +
                '}';
    }
}
