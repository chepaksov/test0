package service;

import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import model.User;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;



import java.util.List;

public class UserServiceHibernate {

    private static UserServiceHibernate userServiceHibernate;

    private SessionFactory sessionFactory;

    public UserServiceHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserServiceHibernate getInstance() {
        if (userServiceHibernate == null) {
            userServiceHibernate = new UserServiceHibernate(DBHelper.getSessionFactory());
        }
        return userServiceHibernate;
    }
    

    public List<User> getAllUsers() {
        List<User> user = new UserHibernateDAO(sessionFactory.openSession()).getAllUser();
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
            new UserHibernateDAO(sessionFactory.openSession()).addUser(user);
            return true;
        } else return false;

    }

    public void editUser(User user) {
        new UserHibernateDAO(sessionFactory.openSession()).editUser(user, idDelUserHql(user.getName()));
    }

    public void delUser(String name) {
        new UserHibernateDAO(sessionFactory.openSession()).delUserHql(name, idDelUserHql(name));
    }

    public Long idDelUserHql (String name) {
        long id = 0;
        List <User> list = new UserHibernateDAO(sessionFactory.openSession()).getAllUser();
        for (User s: list){
            if(s.getName().equals(name)) {
                id = s.getId();
            }

        }
        return id;
    }




}