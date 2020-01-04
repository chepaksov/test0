package servlets;


import model.User;
import service.UserService;
import service.UserServiceHibernate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


@WebServlet("/index")

public class SomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> users = new LinkedList<>();
        // List<User> list = new UserService().getAllUsers();
        List<User> list = UserServiceHibernate.getInstance().getAllUsers();
        for (User s : list) {
            users.add(s.getName());
        }
        resp.setContentType("text/html;charset=utf-8");
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}


