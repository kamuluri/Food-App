<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="com.jsp.foodapp.entities.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<Product> products=(List)request.getAttribute("productslist") ;%>
<table cellpadding="20px" border=1">
<th>id</th>
<th>name</th>
<th>type</th>
<th>cost</th>
<th>edit</th>
<th>delete</th>

<% for(Product p:products) {%>
	<tr>
		<td><%=p.getId() %></td>
		<td><%=p.getName() %></td>
		<td><%=p.getType() %></td>
		<td><%=p.getCost() %></td>
		<td><a href="editproduct?id=<%=p.getId()%>">Edit</a></td>
		<td><a href="deleteproduct?id=<%=p.getId()%>">Delete</a></td>
	
	
	</tr>
<%} %>
<a href="AdminMenu.jsp">Log out</a>
</table>
</body>
</html>