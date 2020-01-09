package servlets;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = UserService.getInstance().getAllUsers();
        resp.setContentType("text/html;charset=utf-8");
        req.setAttribute("users", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin/admin.jsp");
        dispatcher.forward(req, resp);

    }






}
