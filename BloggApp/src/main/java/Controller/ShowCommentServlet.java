package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Comments;
//view spicific comments 
@WebServlet("/showComments")
public class ShowCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection) config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
		int id=Integer.parseInt(request.getParameter("topicid"));
		ps=con.prepareStatement("select *from comments where topicid=?");
		ps.setInt(1, id);
		rs=ps.executeQuery();
		Set<Comments> cmt=new HashSet();
		
		
		while(rs.next())
		{
			Comments comments=new Comments(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			cmt.add(comments);	
		}
getServletContext().setAttribute("cmlist", cmt);
		
		RequestDispatcher rd = request.getRequestDispatcher("/showComments.jsp");
		rd.include(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
