<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="createBean.jsp" >
	Enter Name : 
	<input type="text" name="uid"/> 
	<br/>
	Enter EmailID : 
	<input type="email" name="email"/>
	<br/>
	Enter Contact Number : 
	<input type="text" name="contact"/>
	<br/>
	
	Enter Address 
	<input type="text" name="add"/>
	<br/> 
	
	<input type="submit" value="Submit Data"/>
	<input type="reset" value="Clear"/>
</form>
</body>
</html>