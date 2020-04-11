<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="com.InventoryManagement.Model.Item"%>
<%@ page import ="com.InventoryManagement.Controllers.AddItemController"%>
<link rel="stylesheet" type="text/css" href="css/AddItem.css">
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
<div class="topnav" id="myTopnav">
  <a href="AdminPanel.jsp" class="active">Home</a>
  <a href="#news">Profile</a>
  <a href="#contact">Messages</a>
 
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>
<div class="sidenav">
<div class="welcmediv">
	<h3 style="color: white">Welcome Admin</h3>
	<h3 style="color: white"><%=name %></h3>
	<a style="font-size: small;color: firebrick;text-align: center;" href = "logout.jsp">Click here to logOut</a>
	</div>
  <a href="ViewItemController">View Items</a>
  <a href="AddItem.jsp">Add Items</a>
  <a href="#clients">View Users</a>
  <a href="#contact">Add User</a>
</div>
<div class="Content">
<form action ="ViewItemController" method = "get">
	<input type= "submit" value = "view Items"/>
</form>
<form action="UpdateItemContoller" method = "post">
<table>

<%
		try{
			ArrayList<Item> itemList= (ArrayList<Item>)request.getAttribute("listItem");	

				for(Item item: itemList) {
				%>
				<tr>
<td><label>Item Name</label></td>
<td><input type= "text" name="name" value="<%=item.getIname() %>"></td>
</tr>
<tr>
<td><label>Item Code</label></td>
<td><input type= "text" name="code" value="<%=item.getIcode() %>"></td>
</tr>
<tr>
<td><label>Item Quantity</label></td>
<td><input type= "text" name="quantity" value="<%=item.getQuantity() %>" ></td>
</tr><tr>
<td><label>Item Price</label></td>
<td><input type= "text" name="price" value="<%=item.getPrice() %>"></td>
</tr>
	<tr>
	<td><input type = "submit" value="Update"></td>
	</tr>			
			<%
			
			
			}
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		%>	
</table>
</form>
</div>
</body>
</html>