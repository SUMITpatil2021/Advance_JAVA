<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>List Of Contacts</h1>
 <table border="1">
 <tr>
 		<td>Cid</td>
 	 	<td>Uid</td>
 	 	<td>Password</td>
 	 	<td>First name</td>
 	 	<td>Last Name</td>
 	 	<td>Email ID</td>
 	 	<td>Contact No.</td>
 	 	<td>Edit</td>
 	 	<td>Delete</td>
 	
 </tr>
<c:forEach var="contact" items="${clist }">
	<tr>
		<td>${contact.cid }</td>
		<td>${contact.uid }</td>
		<td>${contact.password}</td>
		<td>${contact.fname }</td>
		<td>${contact.lname}</td>
		<td>${contact.email }</td>
		<td>${contact.contactno }</td>
		<td><a href="edit?cid=${contact.cid}">EDIT</a></td>
		<td><a href="edit?cid=${contact.cid }">DELETE</a></td>
	</tr>
</c:forEach> 
 </table>
 <br/>
 
 <a href="create">Create New Contact</a>
 
</body>
</html>