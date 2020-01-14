package service;


import dao.DAOFactory;
import interfaces.UserDAO;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;


import java.util.List;


public class UserService {

    private UserDAO userDAO = DAOFactory.getDAOFactory().createUserDAO();

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
        List<User> user = userDAO.getAllUser();
        return user;
    }

    public boolean existUser(String name) {
        List<User> user = getAllUsers();
        for (User s : user) {
            if (s.getName().equals(name)){
                return true;
            }
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

    public String checkAuth(User user) {
        User test = userDAO.checkAuth(user.getName());
        if (test.getPassword().equals(user.getPassword())) {
            return test.getRole();
        }
        return null;

    }


}
