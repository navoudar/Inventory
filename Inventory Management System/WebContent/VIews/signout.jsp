<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	// session expiring and redirecting is done by this
	session = request.getSession();
	String email = "";
	if (session.getAttribute("session_user") == null || session.getAttribute("session_user") == ""
			|| session.getAttribute("session_user").equals("")) {

		response.sendRedirect("login.jsp");

	} else {
		email = session.getAttribute("session_user").toString();
	}
%>

<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Progma", "no-cache");
	response.setDateHeader("Expires", 0);
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>sign out</title>
</head>
<body>
	<h1>Sign out page</h1>

	<%
 	if(session.getAttribute("session_user")!= null){
 		
 		session.removeAttribute("session_user");
 		request.getSession(false);
 		session.setAttribute("session_user", null);
 		session.invalidate();
 		
 		response.sendRedirect("index.jsp");
 		
 	}
 %>

</body>
</html>