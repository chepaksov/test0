package web.controller;


import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.server.WebSession;
import web.model.Car;
import web.service.CarServiceImp;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller

public class CarsController {

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<Car> messages = new CarServiceImp().getUser();
        model.addAttribute("messages", messages);
        return "cars";
    }
}
