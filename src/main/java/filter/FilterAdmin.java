package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import service.UserService;
import servlets.*;


@WebFilter("/*")
public class FilterAdmin implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, NullPointerException {

        HttpSession httpSession = ((HttpServletRequest) request).getSession();
        String role = (String) httpSession.getAttribute("role");
        response.setContentType("text/html;charset=utf-8");
        if (role == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);

        } else if (role.equals("user")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/user"); // редирект
            dispatcher.forward(request, response);
        } else if (role.equals("admin")) {
            chain.doFilter(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
