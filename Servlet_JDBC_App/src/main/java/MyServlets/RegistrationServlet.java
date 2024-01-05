package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcurl="jdbc:mysql://localhost:3306/shoppingdb";
			con=DriverManager.getConnection(jdbcurl,"root","sumit");
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try
		{
		String query="insert into users values(?,?,?,?,?,?,?)";
		PreparedStatement pr=con.prepareStatement(query);
		
		String u_id=request.getParameter("u_id");
		String password=request.getParameter("password");
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		
				
		pr.setString(1,u_id);
		pr.setString(2, password);
		pr.setString(3, fname);
		pr.setString(4, mname);
		pr.setString(5, lname);
		pr.setString(6, email);
		pr.setString(7, contact);
		
		int res=pr.executeUpdate();
		
		if(res>0)
		{
			out.print("<h1>"+res+" row inserted successfully ");
		}
		else
		{
			out.print("<h1>Data couldnt insreted </h1>");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		

}
