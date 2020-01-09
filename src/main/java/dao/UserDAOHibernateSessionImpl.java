package dao;

import interfaces.UserDAO;
import service.UserService;

public class UserDAOHibernateSessionImpl {
public UserDAO getUd () {
   return new UserHibernateDAO(UserService.getInstance().getSesFac().openSession());
}
}
