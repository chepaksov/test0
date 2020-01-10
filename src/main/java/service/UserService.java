package service;

import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import exception.DBException;
import interfaces.UserDAO;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    private static UserService userService;


    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }



    public SessionFactory getSesFac() {
        return DBHelper.getInstance().getSessionFactory();

    }
    public UserService() {
        this.userDAO = new UserHibernateDAO(getSesFac().openSession());
    }




    public List<User> getAllUsers() {
        List<User> user = userDAO.getAllUser();
        return user;
    }

    public boolean existUser(String name) {
        List<User> user = getAllUsers();
        for (User s : user) {
            if (s.getName().equals(name)) return true;
        }
        return false;
    }


    public boolean addUser(User user) {
        if (!existUser(user.getName())) {
            userDAO.addUser(user);
            return true;
        } else return false;

    }

    public void editUser(User user) {
        userDAO.editUser(user);
    }

    public void delUser(String name) {
        userDAO.delUser(name);
    }





}
