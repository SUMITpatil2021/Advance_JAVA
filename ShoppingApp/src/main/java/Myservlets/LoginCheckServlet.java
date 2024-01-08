package Myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Classes.User;


@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con=(Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String u_id=request.getParameter("u_id");
		String password=request.getParameter("password");
		
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ResultSet rs=null;
		//ResultSet rs1=null;
		
		try
		{
			ps=con.prepareStatement("select * from users where u_id=? and password=?");
			ps.setString(1, u_id);
			ps.setString(2,password);
			
			rs=ps.executeQuery();
			boolean flag=false;
			User user=null;
			while(rs.next())
			{
				if(rs.getString(1).equals(u_id) && rs.getString(2).equals(password))
				{
					user =new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					flag=true;
					break;
				}
			}
			
			if(flag)
			{
			out.print("<h1>sucess Login </h1>");
			
			Cookie [] all=request.getCookies();
			if(all !=null)
			{
				for(Cookie c:all)
				{
					if(c.getName().equals("loginerror"))
					{
						c.setMaxAge(0);
						response.addCookie(c);
					}
				}
			}
			
			
			//Log Table 
			// using Date class 
//			Date d1=new Date();
//			String logindate=d1.toString()+"";
//			System.out.println(logindate);
//			ps=con.prepareStatement("insert into logtable(userid,loggedintime) values(?,?)");
//			ps.setString(1,u_id);
//			ps.setString(2, logindate);
//			int res=ps.executeUpdate();
//			System.out.println(res+" user Logged in at "+logindate);
			
			// Using Timestamp class
			Timestamp logindate=new Timestamp(new java.util.Date().getTime());
			ps1=con.prepareStatement("insert into logtable(userid,logintime) values(?,?)");
			
			ps1.setString(1,u_id);
			ps1.setTimestamp(2, logindate);
			int res=ps1.executeUpdate();
			System.out.println(res+" user Logged in at "+logindate);
			
			// Create Session level attribute - userinfo 
			HttpSession session=request.getSession();
			session.setAttribute("loggedinuser", user);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("/home");
			rd.forward(request, response);
			}
			else
			{
//				out.print("<h1>Failed Login </h1>");
//				response.sendRedirect("/ShoppingApp/login.jsp");
				
				Cookie c = new Cookie("loginerror","Wrong_UID/pwd");
				response.addCookie(c);
				response.sendRedirect("/ShoppingApp/login.jsp");
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			rs.close();
			ps.close();
			//rs1.close();
			ps1.close();

			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}

}
