package servlet;

import com.google.gson.Gson;
import model.Car;
import service.CarService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProducerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Car car = new Car();
        car.setBrand(req.getParameter("brand"));
        car.setModel(req.getParameter("model"));
        car.setLicensePlate(req.getParameter("licensePlate"));
        car.setPrice(Long.parseLong(req.getParameter("price")));


        if (CarService.getInstance().addCar(car)) {
            resp.setStatus(HttpServletResponse.SC_OK);

        } else resp.setStatus(HttpServletResponse.SC_FORBIDDEN);


    }
}
