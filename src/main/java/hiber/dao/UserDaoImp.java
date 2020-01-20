package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(User user, Car car) {
        sessionFactory.getCurrentSession().save(car);
        sessionFactory.getCurrentSession().save(user);
    }


    @Override
    public User getUser(Car car) {
        String hql = "FROM User where car.name = :name and car.series = :series";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        String name = car.getName();
        int series = car.getSeries();
        query.setParameter("name", name);
        query.setParameter("series", series);
        //  query.setParameter("series", car.getSeries());
        List<User> users = query.getResultList();
        return users.get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

}
