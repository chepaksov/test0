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

    private SessionFactory sessionFactory;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(DBHelper.getSessionFactory());
        }
        return userService;
    }
    public UserService() {
        this.userDAO = new UserHibernateDAO(sessionFactory.openSession());
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


    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_example?").          //db name
                    append("user=root&").          //login
                    append("password=root").       //password
                    append("&serverTimezone=UTC");   //setup server time

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }


}
