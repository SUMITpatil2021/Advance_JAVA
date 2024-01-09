<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Connection con=(Connection)application.getAttribute("jdbccon");
	List<Integer>plist=null;
	plist=(List)session.getAttribute("cart");
%>
<%
	if(plist==null)
	{
		%>
		<h2>Cart Is Empty</h2>
		<br/> <a href='home'>Go Back For Selection</a>
		<% 
	}
	else
	{
		PreparedStatement ps=null;
		ResultSet rs=null; %>
		<table border="1">
		<%
			int count=0;
			float total=0;
			for(int n:plist)
			{
				ps=con.prepareStatement("select * from product where p_id=?");
				ps.setInt(1,n);
				rs=ps.executeQuery();
				rs.next();%>
				<tr>
				<%= "<td>"+(++count)+"</td>"%>
				<%= "<td>"+rs.getString(2)+"</td>" %>
				<%= "<td>"+rs.getFloat(4)+"</td>" %>
				</tr>
				<% total+=rs.getFloat(4);
			}	%>
			<tr>
			<td colspan="2">Total Price </td>
			<%="<td>"+total+"</td>" %>
		</tr>
</table>
<% 
		session.setAttribute("tprice", total );
	}
%>
<br/><a href='home'>GO Back For Selection </a>
<br/> <a href='confirmcart'>Confirm Cart</a>
  
</body>
</html>