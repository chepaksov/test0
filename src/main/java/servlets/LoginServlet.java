package servlets;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role;
        HttpSession httpSession = req.getSession();
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User(name, password);
        role = UserService.getInstance().checkAuth(user);
        httpSession.setAttribute("role", role);
        resp.setContentType("text/html;charset=utf-8");
        if (role == null) {

            resp.sendRedirect("/login");

        }

        if (role.equals("user")) {
            resp.sendRedirect("/user");

        } else if (role.equals("admin")) {
            resp.sendRedirect("/admin");

        } else {
            resp.sendRedirect("/login");
        }


    }
}
