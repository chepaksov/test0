package dao;

import interfaces.UserDAO;

public class DAOHibernateFactorySession extends DAOFactory {
    @Override
    public UserDAO createUserDAO() {
        return new UserDAOHibernateSessionImpl().getUd();
    }
}
