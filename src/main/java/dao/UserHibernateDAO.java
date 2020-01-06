package dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import interfaces.UserDAO;
import model.User;

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
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE User SET password = :password, role = :role  WHERE name = :name");
        query.setParameter("name", user.getName()).setParameter("password", user.getPassword()).setParameter("role", user.getRole()).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void delUser(String name) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE User WHERE name = :name");
        query.setParameter("name", name).executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public User checkAuth(String name) {
        Transaction transaction = session.beginTransaction();
        User user = (User) session.createQuery("from User WHERE name = :name").setParameter("name", name).getSingleResult();
        transaction.commit();
        session.close();
        return user;

    }


}
