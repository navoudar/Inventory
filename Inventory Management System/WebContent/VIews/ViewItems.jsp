<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Items</title>

<%@ page import ="java.util.ArrayList"%>
<%@ page import ="com.InventoryManagement.Model.Item"%>
<%@ page import ="com.InventoryManagement.Controllers.AddItemController"%>

<link rel="stylesheet" type="text/css" href="css/ViewItem.css">
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
<table style="width: 90% ;margin-left: 100px; margin-top: 100px;" id="customers">
			<tr>
				<th>Item Code</th>
				<th>Item Name</th>
				<th>Quantity</th>
				<th>Price</th>

			</tr>
			<%
		try{
			ArrayList<Item> itemList= (ArrayList<Item>)request.getAttribute("itemList");	

				for(Item item: itemList) {
				%>
			<tr>
				<td style="text-align: center;"><%=item.getIcode()%></td> 
			
				<td style="text-align: center;"><%=item.getIname()%></td>

				<td style="text-align: center;"><%=item.getQuantity()%></td>

				<td style="text-align: center;"><%=item.getPrice()%></td>
				
				<td><form action="UpdateItemContoller" method="get">
				<input type="hidden" name="Icode" value="<%=item.getIcode()%>">
				<input type="submit" value="UPDATE">
				</form></td>
				<td><form action="DeleteItemController" method="GET">
				<input type="hidden" name="Icode" value="<%=item.getIcode()%>">
				<input type="submit" value="DELETE">
				</form></td>


			</tr>

		
			<%
			
			
			}
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		%>
		
		
</table>
</div>
<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>


</body>
</html>