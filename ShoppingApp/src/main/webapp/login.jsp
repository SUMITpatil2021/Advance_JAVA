<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%
    Cookie [] all = request.getCookies();
	if(all != null)
	{
		for(Cookie c : all)
		{
			if(c.getName().equals("loginerror"))
			{
				out.print(c.getValue());
			}
		}
	}     
    %>
<form action="loginCheck" method="post">
	Enter User Name 
	<input type="text" name="u_id"/>
	
	<br/>
	Enter Password  
	<input type="password"  name="password"/>  <br/>   
	
	<input type="submit" value="Login" /> 
	<input type="reset" value="Clear" />
	
	 </form>
	 
</body>
</html>