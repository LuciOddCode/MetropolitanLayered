package lk.ijse.metropolitan.bo.custom.impl;

import lk.ijse.metropolitan.bo.custom.SignUpBO;
import lk.ijse.metropolitan.dao.DAOFactory;
import lk.ijse.metropolitan.dao.custom.UserDAO;

public class SignUpBOImpl implements SignUpBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
}
