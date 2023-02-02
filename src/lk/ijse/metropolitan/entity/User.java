package lk.ijse.metropolitan.entity;

public class User {
    private String userName;
    private String passWord;
    private String designation;
    private String eId;

    public User() {
    }

    public User(String userName, String passWord, String designation, String eId) {
        this.userName = userName;
        this.passWord = passWord;
        this.designation = designation;
        this.eId = eId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", designation='" + designation + '\'' +
                ", eId='" + eId + '\'' +
                '}';
    }
}
