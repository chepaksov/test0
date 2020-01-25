package web.dao;


import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getUser() {
        return entityManager.createQuery("FROM User").getResultList();

    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
      //  entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));

          entityManager.remove(getUserById(id));
    }

    @Override
    public User getUserById(int id) {
        return (User) entityManager.createQuery("FROM User where id=:id").setParameter("id", id).getSingleResult();
    }


    @Override
    public void add(User user) {
        entityManager.persist(user);

    }

}
