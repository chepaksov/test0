import com.google.gson.Gson;
import model.Car;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import service.CarService;
import servlet.CustomerServlet;
import servlet.DailyReportServlet;
import servlet.NewDayServlet;
import servlet.ProducerServlet;

public class Main {

    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(CustomerServlet.class, "/customer");
        context.addServlet(ProducerServlet.class, "/producer");
        context.addServlet(NewDayServlet.class, "/newday");
        context.addServlet(DailyReportServlet.class, "/report/*");


        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();


    }
}
