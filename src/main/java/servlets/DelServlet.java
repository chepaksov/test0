package servlets;



import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del")

public class DelServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("param1");
        //  new UserService().delUser(name);
        new UserService().delUser(name);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("удалил");

    }
}
