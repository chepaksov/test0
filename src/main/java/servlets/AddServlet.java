package servlets;

import model.User;
import service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")

public class AddServlet extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        if (UserService.getInstance().addUser(new User(req.getParameter("name"), req.getParameter("password"), req.getParameter("role")))) {

            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("добавил");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("не добавил");
        }


    }

}