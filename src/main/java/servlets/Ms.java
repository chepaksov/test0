package servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Ms extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        try {
            response.getWriter().println(Integer.parseInt(request.getParameter("value"))*2);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            response.getWriter().println(0);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
