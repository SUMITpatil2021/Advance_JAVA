<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border=2>
<tr>
	<th>User</th>
	<th>Comment</th>

</tr>
<c:forEach var="cmnt" items="${applicationScope.cmlist}">
<tr>

	<td>${cmnt.uid}</td>
	<td>${cmnt.text}</td>

</tr>
 </c:forEach>	
</table>
</body>
</html>