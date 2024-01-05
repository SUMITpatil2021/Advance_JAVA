package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WPT_Servlet
 */
@WebServlet(
		urlPatterns = { "/wpt" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "Web Programming")
		})
public class WPT_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		ServletConfig config=getServletConfig();
		String sub=config.getInitParameter("subject");
		
		ServletContext context=getServletContext();
		String provider=context.getInitParameter("provider");
		
		out.print("<h1>Training on "+sub+" by "+provider+"</h>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
