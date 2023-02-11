package lk.ijse.metropolitan.bo.custom;

import lk.ijse.metropolitan.bo.SuperBO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    boolean validateUserName(String userName) throws SQLException, ClassNotFoundException;

    boolean validatePassword(String userName,String passWord) throws SQLException, ClassNotFoundException;

    String validateUsername(String username) throws SQLException, ClassNotFoundException;
}
