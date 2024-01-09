package Myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addtocart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("product"));
		List<Integer> plist=null;
		HttpSession session=request.getSession();
		plist=(List)session.getAttribute("cart");
		if(plist==null)
		{
			plist=new ArrayList<Integer>();
		}
		plist.add(pid);
		session.setAttribute("cart", plist);
		
		PrintWriter out=response.getWriter();
		out.print("Pid "+pid+" is Added  in the cart <br/>");
		out.print("<br/><a href='home'> Go Back To Home </a>");
		out.print("<br/> <a href='viewcart.jsp'>View Cart</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
