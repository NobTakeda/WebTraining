package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Application Lifecycle Listener implementation class ListenerSample
 *
 */
@WebListener
public class ListenerSample implements ServletContextListener {

    /**
     * Default constructor.
     */
    public ListenerSample() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext context=sce.getServletContext();
    	Integer count=0;
    	context.setAttribute("count", count);
    }
}
