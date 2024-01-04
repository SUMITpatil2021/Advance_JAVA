package MyServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/logincheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid=req.getParameter("uid");
		String pwd=req.getParameter("pwd");
		
		if(uid.equals("Sumit") && pwd.equals("Sumit@2021"))
		{
			resp.getWriter().print("Login Success");
		}
		else
		{
			resp.getWriter().print("Login Failed ");
		}
		
	}

}
