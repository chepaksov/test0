package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/admin/*")
public class FilterAdmin implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");
        if (role == null) {
            res.sendRedirect("login");
        } else if (role.equals("user")) {
            res.sendRedirect("user");
        } else if (role.equals("admin")) {
            chain.doFilter(request, response);
        }
    }


    @Override
    public void destroy() {

    }
}
