package dao;

import interfaces.UserDAO;
import service.UserService;
import util.DBHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class DAOFactory {

    public abstract UserDAO createUserDAO();

    public static DAOFactory getDAOFactory() {
        DAOFactory daoFactory = null;
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("C:/Users/1/Desktop/test/src/main/resources/config.property");
            property.load(fis);

            String daoType = property.getProperty("type");


            if (daoType.equals("Hibernate")) {
                return daoFactory = new DAOHibernateFactorySession();
            } else if (daoType.equals("JDBC")) {
                return daoFactory = new DAOJDBCFactory();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return daoFactory;


    }


}
