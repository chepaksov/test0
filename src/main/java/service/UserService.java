package service;


import dao.DAOFactory;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;


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




    public List<User> getAllUsers() {
        List<User> user = DAOFactory.getDAOFactory().createUserDAO().getAllUser();
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
            DAOFactory.getDAOFactory().createUserDAO().addUser(user);
            return true;
        } else return false;

    }

    public void editUser(User user) {
        DAOFactory.getDAOFactory().createUserDAO().editUser(user);
    }

    public void delUser(String name) {
        DAOFactory.getDAOFactory().createUserDAO().delUser(name);
    }

    public String checkAuth(User user) {
        User test = DAOFactory.getDAOFactory().createUserDAO().checkAuth(user.getName());
        if (test.getPassword().equals(user.getPassword())) {
            return test.getRole();
        }
        return null;

    }


}
