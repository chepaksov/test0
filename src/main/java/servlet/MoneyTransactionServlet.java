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

public class MoneyTransactionServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(PageGenerator.getInstance().getPage("moneyTransactionPage.html", new HashMap<>()));
        resp.setStatus(HttpServletResponse.SC_OK);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "The transaction was successful");
        Map<String, Object> map0 = new HashMap<>();
        map0.put("message", "transaction rejected");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("senderName");
        String password = req.getParameter("senderPass");
        Long count = (long) Integer.parseInt(req.getParameter("count"));
        String nameTo = req.getParameter("nameTo");

        BankClient bc = new BankClient(name, password, (long) 0);
        BankClientService bankClientService = new BankClientService();
        if (bankClientService.sendMoneyToClient(bc, nameTo, count)) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(PageGenerator.getInstance().getPage("resultPage.html", map));

        }
        else {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(PageGenerator.getInstance().getPage("resultPage.html", map0));
        }
    }
}
