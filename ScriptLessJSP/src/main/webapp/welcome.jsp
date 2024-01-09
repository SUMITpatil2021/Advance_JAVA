<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome To JSP </h1>
	<br/>
	
	<!-- HTML COMMENTS  -->
	<%--JSP Comment --%>
	<%
		int n=2;
	n++;
	out.println("Value of n :"+n);
	%>
	<br/>
	
	
	<%= Calendar.getInstance().getTime() %> 
	<br/>
	
	<%! int count=0; %>
	<%="Count : "+(++count) %>
	
	
</body>
</html>