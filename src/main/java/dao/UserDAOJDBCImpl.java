package dao;

import interfaces.UserDAO;
import service.UserService;
import util.DBHelper;

public class UserDAOJDBCImpl {
    public UserDAO getUd () {
        return new UserJdbcDAO((DBHelper.getInstance().getConnection()));
    }
}
