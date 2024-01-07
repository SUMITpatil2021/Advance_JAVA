package Myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getProducts")
public class GetProductsServlet extends HttpServlet {
	

	Connection con;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection) config.getServletContext().getAttribute("jdbccon");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement ps=null;
		ResultSet rs=null;
		PrintWriter out=response.getWriter();
		try
		{
			int id=Integer.parseInt(request.getParameter("catid"));
			ps=con.prepareStatement("select *from product where cat_id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			out.print("<form action=''>");
			out.print("Select Product");
			out.print("<select name='product'>");
			while(rs.next())
			{
				out.print("<option value='"+rs.getInt(1)+"'>");
				out.print(rs.getString(2));
				out.print("</option>");
			}
			out.print("</select><br/>");
			out.print("<input type='submit' value='Add To Cart' />");
			out.print("</form");
			out.print("<a href='home') Go Bak To Categories </a>");
			//out.print("<a href='home'> Go  Back To Categories </a>");)
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
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
