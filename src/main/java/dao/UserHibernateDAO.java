package dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import interfaces.UserDAO;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private Session session;

    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    @Override
    public List<User> getAllUser() {
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void addUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();

    }

    @Override
    public void editUser(User user) {


    }

    @Override
    public void delUser(String name) {

    }

    @Override
    public void delUserHql(String name, long id) {
        Transaction transaction = session.beginTransaction();
        User employee = (User) session.get(User.class, id);
        session.delete(employee);
        transaction.commit();
        session.close();

    }

    @Override
    public void editUserHql(User user, Long id) {
        Transaction transaction = session.beginTransaction();
        User employee = (User) session.get(User.class, id);
        session.update(employee);
        transaction.commit();
        session.close();
    }


}
