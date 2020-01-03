package dao;

import interfaces.UserDAO;
import model.User;

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
                String example = result.getString("example");
                au.add(new User(id, name, password, example));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return au;

    }

    public void addUser(User user) {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement("insert users (NAME, PASSWORD, example) VALUES (?,?,?)");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getExample());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE users SET password = ?, example = ?  WHERE name LIKE ?");
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getExample());
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
    public void delUserHql(String name, long id) {

    }

    @Override
    public void editUser(User user, Long id) {

    }


}
