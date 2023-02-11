package lk.ijse.metropolitan.dto;

public class ProductDTO {
    private String pId;
    private String type;
    private String brand;
    private String desc;
    private String qtyOnHand;
    private String buyingPrice;
    private String sellingPrice;


    public ProductDTO(String pId, String type, String brand, String desc, String qtyOnHand, String buyingPrice, String sellingPrice) {
        this.pId = pId;
        this.type = type;
        this.brand = brand;
        this.desc = desc;
        this.qtyOnHand = qtyOnHand;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }

    public ProductDTO() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(String qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(String buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "pId='" + pId + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", desc='" + desc + '\'' +
                ", qtyOnHand='" + qtyOnHand + '\'' +
                ", buyingPrice='" + buyingPrice + '\'' +
                ", sellingPrice='" + sellingPrice + '\'' +
                '}';
    }
}
