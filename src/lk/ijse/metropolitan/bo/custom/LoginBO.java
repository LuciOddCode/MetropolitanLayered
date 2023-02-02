package lk.ijse.metropolitan.bo.custom;

import lk.ijse.metropolitan.bo.SuperBO;

public interface LoginBO extends SuperBO {
    boolean validateUserName(String text);

    boolean validatePassword(String text);

}
