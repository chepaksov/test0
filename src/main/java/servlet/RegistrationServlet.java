package servlet;

import model.User;
import service.UserService;
import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        Map<String, Object> data = createPageVariablesMap(req);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(PageGenerator.getInstance().getPage("registerPage.html", data));
        resp.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doPost(req, resp);

        resp.setContentType("text/html;charset=utf-8");
        String email = req.getParameter("email");

        String password = req.getParameter("password");
        User user = new User((long) 0, email, password);
        UserService us = UserService.getInstance();
        resp.setContentType("text/html;charset=utf-8");
        if (us.addUser(user)) {
            resp.getWriter().println("Пользователь удачно создан");
        } else {
            resp.getWriter().println("ошибка");
        }
    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest req) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", req.getMethod());
        pageVariables.put("URL", req.getRequestURL().toString());
        pageVariables.put("pathInfo", req.getPathInfo());
        pageVariables.put("sessionId", req.getSession().getId());
        pageVariables.put("parameters", req.getParameterMap().toString());
        return pageVariables;
    }
}
