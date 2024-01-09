<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Welcome to JSP </h1>
	<br/>
	This is template text
	<br/>
	<!--  This is HTML comment -->
	<%-- This is JSP comment --%>
	<%
	   int n=0;
	   n++;
	   out.println("Value of n : "+n);
	%>
	<br/>
	<%=  Calendar.getInstance().getTime()   %>
	<br/>
	<%! int count; %>
	<%= "Count : "+(++count) %>
</body>
</html>




