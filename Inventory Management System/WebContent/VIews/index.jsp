<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Online BookMart</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<h1>Online BookMart</h1>
<h3>The best place to find all the book you want</h3>

<form action="login.jsp">
			<button type="submit" class="button" style="vertical-align:middle"><span>Login</span></button>
		</form>
		<form action="SignUp.jsp">
			<button type="submit" class="button" style="vertical-align:middle"><span>Register</span></button>
		</form>
		
<a href="Update.jsp">Update Item</a>

<form action ="ViewItemController" method = "get">
	<input type= "submit" value = "view Items"/>
</form>
</body>
</html>