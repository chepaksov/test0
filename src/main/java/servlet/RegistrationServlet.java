package servlet;

import model.BankClient;
import service.BankClientService;
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
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(PageGenerator.getInstance().getPage("registrationPage.html", new HashMap<>()));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Add client successful");
        Map<String, Object> map0 = new HashMap<>();
        map0.put("message", "Client not add");


        Long money = (long) Integer.parseInt(req.getParameter("money"));

        BankClient bc = new BankClient(name, password, money);
        BankClientService bcs = new BankClientService();

        if (bcs.addClient(bc)) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(PageGenerator.getInstance().getPage("resultPage.html", map));
        }
        else {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(PageGenerator.getInstance().getPage("resultPage.html", map0));

        }
    }
}
