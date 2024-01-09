<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean  id="userinfo" class="Beans.User" scope="session" />
<jsp:setProperty  name="userinfo"  property="uid" param="uid"/>
<jsp:setProperty  name="userinfo"  property="email" param="email"/>
<jsp:setProperty  name="userinfo"  property="contact" param="contact"/>
<jsp:setProperty  name="userinfo"  property="add" param="add"/>

<jsp:forward page="/displayBean.jsp"/>

</body>
</html>