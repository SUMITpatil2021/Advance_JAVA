package Controller;

import java.io.IOException;
import java.sql.Connection;
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
import beans.Topic;

// view specific comments 

@WebServlet("/viewallComments")
public class ViewAllCommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection) config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<SubComment> comments= new HashSet<>();
		Statement stmt=null;
		ResultSet rs=null;
		 SubComment subcomment;
		try
		{
			stmt=con.createStatement();
		rs=stmt.executeQuery("Select c.text,t.name from comments c,topic t where c.topicid=t.topicid");
		Set<Comments> cmnts=new HashSet();
		while(rs.next())
		{
			Topic topic=new Topic(rs.getString(2));
			Comment comment=new Comment(rs.getString(1));
			subcomment=new  SubComment(topic,comment);
			comments.add(subcomment);
		}
		getServletContext().setAttribute("clist", cmnts);
		
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
