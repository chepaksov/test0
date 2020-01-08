package filter;

import servlets.LoginServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/user/*")
public class FilterUser implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (LoginServlet.role == null) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        }
        else if (LoginServlet.role.equals("admin") || LoginServlet.role.equals("user")){
            chain.doFilter(request, response);
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
