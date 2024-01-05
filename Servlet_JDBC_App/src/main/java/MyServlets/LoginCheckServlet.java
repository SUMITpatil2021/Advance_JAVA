package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/logincheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public void init(ServletConfig config) throws ServletException {
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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("u_id");
		String pwd=request.getParameter("password");
		PrintWriter out=response.getWriter();
		try
		{
		String query="select * from users where u_id=? and password=?";
		PreparedStatement pr=con.prepareStatement(query);
		
		pr.setString(1,uid);
		pr.setString(2, pwd);
		
		ResultSet rs=pr.executeQuery();	
		boolean flag=false;
		
		while(rs.next())
		{
		if(rs.getString(1).equals(uid) && rs.getString(2).equals(pwd))
		{
			flag=true;
			break;
		}
		}
		
		if(flag)
			response.getWriter().print("Login Success");
		else
		{
			response.getWriter().print("Login Failed ");
		}
		
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		}
}
