import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MainServlet;
import servlets.Ms;


public class Main {
    public static void main(String[] args) throws Exception {
        MainServlet mainServlet = new MainServlet();
        Ms ms = new Ms();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mainServlet), "/");
        context.addServlet(new ServletHolder(ms), "/mult");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
