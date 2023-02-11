package lk.ijse.metropolitan.entity;

import java.sql.Date;

public class Custom {
    //customer
    private String cId;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String registeredBy;
//employee
    private String eId;
    private String empName;
    private String empPhone;
    private Date DOB;
    private String empEmail;

    //product
    private String prId;
    private String type;
    private String brand;
    private String description;
    private double buyingPrice;
    private double sellingPrice;
    private double qtyOnHand;

    //Order
    private String oId;
    private String uId;
    private Date orderDate;
    private double total;

    //od
    private double qty;
    private double price;

    public Custom() {
    }

    public Custom(String cId, String name, String email, String address, String phone, String registeredBy, String eId, String empName, String empPhone, Date DOB, String empEmail, String prId, String type, String brand, String description, double buyingPrice, double sellingPrice, double qtyOnHand, String oId, String uId, Date orderDate, double total, double qty, double price) {
        this.cId = cId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.registeredBy = registeredBy;
        this.eId = eId;
        this.empName = empName;
        this.empPhone = empPhone;
        this.DOB = DOB;
        this.empEmail = empEmail;
        this.prId = prId;
        this.type = type;
        this.brand = brand;
        this.description = description;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.qtyOnHand = qtyOnHand;
        this.oId = oId;
        this.uId = uId;
        this.orderDate = orderDate;
        this.total = total;
        this.qty = qty;
        this.price = price;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
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

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
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
        return "Custom{" +
                "cId='" + cId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", registeredBy='" + registeredBy + '\'' +
                ", eId='" + eId + '\'' +
                ", empName='" + empName + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", DOB=" + DOB +
                ", empEmail='" + empEmail + '\'' +
                ", prId='" + prId + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", buyingPrice=" + buyingPrice +
                ", sellingPrice=" + sellingPrice +
                ", qtyOnHand=" + qtyOnHand +
                ", oId='" + oId + '\'' +
                ", uId='" + uId + '\'' +
                ", orderDate=" + orderDate +
                ", total=" + total +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
