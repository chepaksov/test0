package dao;

import interfaces.UserDAO;
import model.User;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    private Connection connection;

    public UserJdbcDAO(Connection connection) {
        this.connection = connection;
    }


    public List<User> getAllUser() {
        List<User> au = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            st.execute("select * from users");
            ResultSet result = st.getResultSet();

            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                String password = result.getString("password");
                String role = result.getString("role");
                au.add(new User(id, name, password, role));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return au;

    }


    public void addUser(User user) {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement("insert users (NAME, PASSWORD, role) VALUES (?,?,?)");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE users SET password = ?, role = ?  WHERE name LIKE ?");
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getRole());
            preparedStatement.setString(3, user.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delUser(String name) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from users WHERE name = ?");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User checkAuth(String name) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from users where name = ?");
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            User user = new User(rs.getString("name"), rs.getString("password"), rs.getString("role"));
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
