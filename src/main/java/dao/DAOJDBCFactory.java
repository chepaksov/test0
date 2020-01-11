package dao;

import interfaces.UserDAO;

public class DAOJDBCFactory extends DAOFactory {
    @Override
    public UserDAO createUserDAO() {
        return new UserJdbcDAO();
    }
}
