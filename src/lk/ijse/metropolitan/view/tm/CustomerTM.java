package lk.ijse.metropolitan.view.tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private String cId;
    private String name;
    private String email;
    private String address;
    private String phone;


    public CustomerTM() {
    }

    public CustomerTM(String cId, String name, String email, String address, String phone) {
        this.cId = cId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;

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


    @Override
    public String toString() {
        return "CustomerTM{" +
                "cId='" + cId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
