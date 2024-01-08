package Myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			
			session.invalidate();
			out.print("<br/> You are logged out successfully ");
			out.print("<br/> <a href='login.jsp'> Login again? </a> ");
		}
		
		Timestamp logotdate=new Timestamp(new java.util.Date().getTime());
		PreparedStatement ps=null;
		
		try
		{
		ps=con.prepareStatement("update logtable set logouttime=? where logouttime is null");
		ps.setTimestamp(1, logotdate);
		ps.executeUpdate();
		System.out.println("Logout Date inserted succefully ");
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		
		}
		finally
		{
			try
			{
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		}
		
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
