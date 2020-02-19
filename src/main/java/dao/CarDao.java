package DAO;

import model.Car;
import model.DailyReport;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarDao {

    private Session session;

    public CarDao(Session session) {
        this.session = session;
    }

    public List<Car> getAllCars() {
        Criteria criteria;
        criteria = session.createCriteria(Car.class);
        List<Car> car = criteria.list();
        return car;

    }


    public void addCar(Car car) {
        Transaction trans = session.beginTransaction();
        session.saveOrUpdate(car);
        trans.commit();
        session.close();
    }

    public int countBrand(Car car) {
        int count = 0;
        List<Car> cb = new ArrayList<>();
        cb = getAllCars();
        for (Car s : cb) {
            if (s.getBrand().equals(car.getBrand())) count++;
        }
        return count;
    }

    public void delete() {
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE FROM Car").executeUpdate();
        transaction.commit();
        session.close();
    }


    public Long buy(Car car) {
        long sch;
        Transaction transaction = session.beginTransaction();
        Car employee = (Car) session.get(Car.class, idDelete(car));
        sch = priceGet(car);

        session.delete(employee);
        transaction.commit();
        return sch;
    }

    public long idDelete(Car car) {
        List<Car> list = getAllCars();
        for (Car s : list) {
            if (s.getBrand().equals(car.getBrand()) && s.getModel().equals(car.getModel()) && s.getLicensePlate().equals(car.getLicensePlate())) {
                return s.getId();
            }
        }
        return 0;

    }

    public long priceGet(Car car) {
        List<Car> list = getAllCars();
        for (Car s : list) {
            if (s.getBrand().equals(car.getBrand()) && s.getModel().equals(car.getModel()) && s.getLicensePlate().equals(car.getLicensePlate())) {
                return s.getPrice();
            }
        }
        return 0;
    }


}
