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

@WebServlet("/edit")

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        String get = req.getParameter("param1");
        req.setAttribute("name", get);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        User user = new User();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String example = req.getParameter("example");
        if (!name.equals("") && !password.equals("") && !example.equals("")) {
            if (new UserService().existUser(name)) {
                user.setName(name);
                user.setPassword(password);
                user.setExample(example);
                new UserService().editUser(user);
                resp.sendRedirect("/index");
            } else {

                resp.getWriter().println("такого юзера нет в базе");
            }

        } else {

            resp.getWriter().println("все поля должны быть заполнены");
        }


    }

}
