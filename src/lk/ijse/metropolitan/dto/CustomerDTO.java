package lk.ijse.metropolitan.dto;

public class CustomerDTO {
    private String cId;
    private String name;
    private String address;
    private String email;
    private String phone;

    public CustomerDTO() {
    }

    public CustomerDTO(String cId, String name, String address, String email, String phone) {
        this.cId = cId;
        this.name = name;
        this.address = address;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "cId='" + cId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
