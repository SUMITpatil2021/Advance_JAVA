<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Products</title>
</head>
<body>
	<% 
	Connection con;
	con=(Connection)application.getAttribute("jdbccon");
	RequestDispatcher rd=request.getRequestDispatcher("/header");
	rd.include(request,response);
	PreparedStatement ps=null;
	ResultSet rs=null;
	int id=Integer.parseInt(request.getParameter("catid"));
	ps=con.prepareStatement("select * from product where cat_id=?");
	ps.setInt(1,id);
	rs=ps.executeQuery();
	%>
	<form action='addtocart'>
		<p>Select Product</p>
		<select name="product">
			<% while(rs.next())
			{ 	%>
				<%="<option value='"+rs.getInt(1)+"'>" %>
				<%=rs.getString(2) %>
				<%="</option>" %>
<%			} %>
</select><br/>
<input type="submit" value="Add To Cart">
		
	</form>
	<a href="home" >Go Back To Categories </a>
</body>
</html>