package web.service;


import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {


    @Override
    public List<Car> getUser() {
        List<Car> cars = new  ArrayList<>();
        cars.add(new Car(1, "a", 5));
        cars.add(new Car(2, "b", 5));
        cars.add(new Car(3, "c", 5));

        return cars;
    }
}
