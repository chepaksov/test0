package service;

import DAO.CarDao;
import model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarService {

    private static CarService carService;

    private SessionFactory sessionFactory;

    public CarService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService(DBHelper.getSessionFactory());
        }
        return carService;
    }

    public List<Car> getAllCars() {
        return new CarDao(sessionFactory.openSession()).getAllCars();
    }

    public boolean addCar(Car car) {
        if (new CarDao(sessionFactory.openSession()).countBrand(car) < 10) {
            new CarDao(sessionFactory.openSession()).addCar(car);
            return true;
        } else return false;
    }

    List<Long> oo = new LinkedList<>();


    public void buy(Car car) {
        oo.add(new CarDao(sessionFactory.openSession()).buy(car));

    }

    public void delete() {
        new CarDao(sessionFactory.openSession()).delete();
    }


}
