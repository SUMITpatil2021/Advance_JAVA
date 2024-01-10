package MyListeners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class BloggAppListener implements ServletContextListener {

   
		Connection con;
	  public void contextInitialized(ServletContextEvent sce)  { 
	        try
	        {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String jdbcurl="jdbc:mysql://localhost:3306/blogdb";
	        con =DriverManager.getConnection(jdbcurl,"root","sumit");
	        System.out.println("Connection Established !!!");
	        sce.getServletContext().setAttribute("jdbccon", con);
	        System.out.println("Con set as context level attributes");			
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	    }
		
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    try
    {
    con.close();	
    
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
    }
}
