package lk.ijse.metropolitan.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.metropolitan.bo.custom.RAYPAppBO;
import lk.ijse.metropolitan.dao.DAOFactory;
import lk.ijse.metropolitan.dao.custom.RAYPAppDAO;

public class RAYPAppBOImpl implements RAYPAppBO {
    RAYPAppDAO appDAO = (RAYPAppDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RAYPA);

    @Override
    public ObservableList getAllApp() {
        return null;
    }
}
