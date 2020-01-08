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

@WebServlet("/admin/edit")

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String get = req.getParameter("param1");
        resp.setContentType("text/html;charset=utf-8");
        req.setAttribute("name", get);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req, resp);


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        User user = new User(name, password, role);
        if (!name.equals("") && !password.equals("") && !role.equals("")) {
            if (UserService.getInstance().existUser(name)) {

                // new UserService().editUser(user);
                UserService.getInstance().editUser(user);
                resp.getWriter().println("изменено");
            } else {

                resp.getWriter().println("такого юзера нет в базе");
            }

        } else {

            resp.getWriter().println("все поля должны быть заполнены");
        }


    }

}
