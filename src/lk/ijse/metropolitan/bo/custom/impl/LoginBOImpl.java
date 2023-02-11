package lk.ijse.metropolitan.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.metropolitan.bo.BOFactory;
import lk.ijse.metropolitan.bo.SuperBO;
import lk.ijse.metropolitan.bo.custom.LoginBO;
import lk.ijse.metropolitan.dao.DAOFactory;
import lk.ijse.metropolitan.dao.custom.UserDAO;
import lk.ijse.metropolitan.entity.User;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean validateUserName(String userName) throws SQLException, ClassNotFoundException {
        boolean isExist = userDAO.exist(userName);
        return isExist;
    }

    @Override
    public boolean validatePassword(String userName,String passWord) throws SQLException, ClassNotFoundException {
        boolean isExist = userDAO.exist(userName);
        if (isExist){
            User search = userDAO.search(userName);
            if (search.getPassWord().equals(passWord)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String validateUsername(String username) throws SQLException, ClassNotFoundException {
        boolean isExist = userDAO.exist(username);
        if (isExist){
            User search = userDAO.search(username);
            return search.getUserName();
        }else {
            return null;
        }
    }
}
