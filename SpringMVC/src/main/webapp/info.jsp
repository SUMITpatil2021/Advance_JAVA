<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Request Data </h1>
	<ul>
		<li>Request URL :${req_url}</li>
		<li>Request Method : ${req_method}</li>
		<li>Request Paramter Count : ${para_count}</li>
		<li>Request Host : ${host}</li>
		
	</ul>
</body>
</html>