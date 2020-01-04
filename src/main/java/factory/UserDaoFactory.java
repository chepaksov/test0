package factory;


import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import interfaces.UserDAO;

import service.UserService;
import util.DBHelper;

import java.io.*;
import java.util.Properties;

public class UserDaoFactory {

    public UserDAO getUserDao() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("C:/Users/1/Desktop/test/src/main/resources/config.property");
            property.load(fis);

            String daoType = property.getProperty("type");


            if (daoType.equals("Hibernate")) {
                return new UserHibernateDAO(UserService.getInstance().getSesFac().openSession());
            } else if (daoType.equals("JDBC")) {
                return new UserJdbcDAO(DBHelper.getInstance().getConnection());
            }


        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсутствует!");
        }
        return null;
    }

}