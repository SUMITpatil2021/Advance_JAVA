  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.text.SimpleDateFormat,java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("hh");
	    String hours = sdf.format(new Date());
	    int hh = Integer.parseInt(hours);
	    if(hh > 6 && hh < 12)
	    {   %>
	    	<%= "<h1> Good Morning </h1>" %>
	    <%  }
	    else if(hh >= 12 && hh <= 16)
	    {  %>
	    	<%=  "<h1> Good Afternoon </h1>" %>
	    <%  }
	    else if(hh > 16 && hh <= 20)
	    {  %>
	    	<%= "<h1> Good Evening </h1>" %>
	    <% }
	    else
	    { %>
	    	<%= "<h1> Good Night </h1>" %>
	    <% }
	%>

	
	
	
</body>
</html>