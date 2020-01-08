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
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public static String role = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User(name, password);
        role = UserService.getInstance().checkAuth(user);
        if(role == null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("ошибка");
        }
        if (role.equals("user")) {
            resp.sendRedirect(req.getContextPath() + "/user");
        } else if (role.equals("admin")) {
            resp.sendRedirect(req.getContextPath() + "/admin");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("ошибка");
        }



    }
}
