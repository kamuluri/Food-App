<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.jsp.foodapp.entities.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Product product=(Product) request.getAttribute("productsdata"); %>
<form action="updatepro" method="post">
enter Id:<input type="number" name="id" value=<%=product.getId() %> readonly="true"><br>
enter Name:<input type="text" name="name" value=<%=product.getName() %>><br>
enter Type:<input type="text" name="type" value=<%=product.getType() %>><br>
enter Cost:<input type="number" name="cost" value=<%=product.getCost() %>><br>
<input type="submit">


</form>
</body>
</html>