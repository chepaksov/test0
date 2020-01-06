package service;


import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;
import factory.*;

import java.util.List;


public class UserService {

    private static UserService userService;


    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    private UserService() {
    }

    public SessionFactory getSesFac() {
        return DBHelper.getInstance().getSessionFactory();

    }


    public List<User> getAllUsers() {

        List<User> user = new UserDaoFactory().getUserDao().getAllUser();
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
            new UserDaoFactory().getUserDao().addUser(user);
            return true;
        } else return false;

    }

    public void editUser(User user) {
        new UserDaoFactory().getUserDao().editUser(user);
    }

    public void delUser(String name) {
        new UserDaoFactory().getUserDao().delUser(name);
    }

    public String checkAuth(User user) {
       User test = new UserDaoFactory().getUserDao().checkAuth(user.getName());
       if (test.getPassword().equals(user.getPassword())) {
           return test.getRole();
       }
       return null;

    }


}
