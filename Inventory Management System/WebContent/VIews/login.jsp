<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<title>login</title>
</head>

	
		<h1>Online BookMart</h1>
		<h3>The best place to find all the book you want</h3>
		

	<h2 style="text-align: center;">Welcome .. Please login to the
		system  .........::</h2>

	<form action="LoginController" method="post" id="login">
		<label>Email ::</label> <input name="email" id="email" type="text"
			placeholder="Enter Your Email Here" required="required" /> <br>
		<br> <label>Password ::</label> <input name="password" id="n2"
			type="password" placeholder="Enter Your Password Here"
			required="required" /> <br>
		<br> <input name="submit" type="submit" value="submit"/>
		<h4>
			Not a Member ?<a href="register.jsp">click here to register</a>
		</h4>

	</form>
</body>
</html>