import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import servlet.ApiServlet;
import servlet.LoginServlet;
import servlet.RegistrationServlet;

public class Main {

    public static void main(String[] args) throws Exception{
        ApiServlet apiServlet = new ApiServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(ApiServlet.class, "/api/*");
       context.addServlet(RegistrationServlet.class, "/register");
       context.addServlet(LoginServlet.class, "/login");


        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
