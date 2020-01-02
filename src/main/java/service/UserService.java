package service;

import dao.UserJdbcDAO;
import exception.DBException;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public UserService() {
    }


    public List<User> getAllUsers() {
        List<User> user = new UserJdbcDAO(getMysqlConnection()).getAllUser();
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
            new UserJdbcDAO(getMysqlConnection()).addUser(user);
            return true;
        } else return false;

    }

    public void editUser(User user) {
        new UserJdbcDAO(getMysqlConnection()).editUser(user);
    }

    public void delUser(String name) {
        new UserJdbcDAO(getMysqlConnection()).delUser(name);
    }


    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_user?").          //db name
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
