package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import service.UserService;
import servlets.*;


@WebFilter("/admin/*")
public class FilterAdmin implements Filter {
    //private UserService userService;
  //  public FilterAdmin(UserService userService) {
       // this.userService = userService;
   // }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, NullPointerException {

    //    HttpSession httpSession = ((HttpServletRequest) request).getSession();
       // userService.ge
      //  httpSession.setAttribute("role", );
        if (LoginServlet.role == null || !LoginServlet.role.equals("admin")) {
            response.setContentType("text/html;charset=utf-8");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);

        }
         else {
            response.setContentType("text/html;charset=utf-8");
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
