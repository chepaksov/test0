package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import servlets.*;



@WebFilter("/admin/*")
public class FilterAdmin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, NullPointerException {
   if (LoginServlet.role == null) {
       RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
       dispatcher.forward(request, response);
   }
        if (LoginServlet.role.equals("admin")) {
        response.setContentType("text/html;charset=utf-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin");
        dispatcher.forward(request, response);
    }
    else {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
        dispatcher.forward(request, response);
    }
    }

    @Override
    public void destroy() {

    }
}
