package lk.ijse.metropolitan.dao.custom.impl;

import lk.ijse.metropolitan.dao.custom.UserDAO;
import lk.ijse.metropolitan.dto.CrudUtil;
import lk.ijse.metropolitan.entity.User;

import java.awt.geom.RectangularShape;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM user;");
        while (rst.next()){
            User user = new User(rst.getString(1),rst.getString(2),rst.getString(3)
                    ,rst.getString(4));

            users.add(user);
        }
        return users;
    }

    @Override
    public boolean add(User u) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO user VALUES(?,?,?,?);",u.getUserName(),u.getPassWord(),u.getUserName()
        ,u.geteId());
    }

    @Override
    public boolean update(User u) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE user SET passWord=?,designation=?,eId=? WHERE userName=?;"
        ,u.getPassWord(),u.getDesignation(),u.geteId(),u.getUserName());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.execute("SELECT * FROM user WHERE userName=?;",id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        //have to enter username manually so not gonna need this
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM user WHERE userName=?;",id);
    }

    @Override
    public User search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rs=CrudUtil.execute("SELECT * FROM user WHERE userName=?;",id);
        if (rs.next()){
            User user=new User(rs.getString("userName"),rs.getString("passWord")
            ,rs.getString("designation"),rs.getString("eId"));

            return user;
        }
        return null;
    }
}
