package lk.ijse.metropolitan.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.metropolitan.bo.custom.LoginBO;

public class LoginBOImpl implements LoginBO {

    @Override
    public boolean validateUserName(String userName) {

        return false;
    }

    @Override
    public boolean validatePassword(String text) {
        return false;
    }
}
