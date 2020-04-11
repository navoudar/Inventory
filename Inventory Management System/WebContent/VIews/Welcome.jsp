<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<%
	// session expiring and redirecting is done by this
	session = request.getSession();
	String email = "";
	String name = "";
	
	if (session.getAttribute("UserName") == null || session.getAttribute("UserName") == ""
			|| session.getAttribute("UserName").equals("")) {

		response.sendRedirect("login.jsp");

	} else {
		email = session.getAttribute("userEmail").toString();
		name = session.getAttribute("UserName").toString();
	}
%>
</head>
<body>
<h1 style ="margin-bottom: 0px;">Hello .....<%=name %></h1>
	<a href = "logout.jsp">Click here to logOut</a>
</body>
</html>