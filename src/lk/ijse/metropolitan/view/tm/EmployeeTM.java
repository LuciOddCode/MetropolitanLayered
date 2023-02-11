package lk.ijse.metropolitan.view.tm;

import javafx.beans.InvalidationListener;
import javafx.collections.ArrayChangeListener;
import javafx.collections.ObservableArray;
import javafx.scene.control.Button;

import java.time.LocalDate;

public class EmployeeTM implements ObservableArray<EmployeeTM> {
    private String eId;
    private String name;
    private String phone;
    private String dob;
    private String email;

    public EmployeeTM() {
    }

    public EmployeeTM(String eId, String name, String phone, String dob, String email) {
        this.eId = eId;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.email = email;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    @Override
    public String toString() {
        return "EmployeeTM{" +
                "eId='" + eId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public void addListener(ArrayChangeListener<EmployeeTM> listener) {

    }

    @Override
    public void removeListener(ArrayChangeListener<EmployeeTM> listener) {

    }

    @Override
    public void resize(int size) {

    }

    @Override
    public void ensureCapacity(int capacity) {

    }

    @Override
    public void trimToSize() {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
