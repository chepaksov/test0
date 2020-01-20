package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        //  userService.add(new Car("14546", 123), new User("User5121231", "Lastname1", "user1@mail.ru"));
        Car car0 = new Car("14546", 123);
        Car car1 = new Car("asdfas", 1232154);
      //  userService.add(car0);
      //  userService.add(car1);
        userService.add(new User("qwe", "sdgf", "bnm", car0), car0);
        userService.add(new User("awd", "awdaw", "dawdaw", car1), car1);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car_id = " + user.getCar().getId());
            System.out.println("Car_name = " + user.getCar().getName());
            System.out.println("Car_series = " + user.getCar().getSeries());
            System.out.println();
        }

        userService.getUser(car0);





        context.close();
    }
}
