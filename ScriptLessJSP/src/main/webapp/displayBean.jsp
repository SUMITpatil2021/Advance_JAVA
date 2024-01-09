<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userinfo" class="Beans.User" scope="session" />
	<h1> Welcome <jsp:getProperty name="userinfo"  property="uid" />
	            
	</h1>
	<p> Email : <jsp:getProperty property="email" name="userinfo"/> </p>
	<p> Contact : <jsp:getProperty property="contact" name="userinfo"/> </p>
	<p> Address : <jsp:getProperty property="add" name="userinfo"/> </p>
	
	
</body>
</html>