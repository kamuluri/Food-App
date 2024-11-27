<%@page import="com.jsp.foodapp.entities.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Item i=(Item)request.getAttribute("itemobj");
%>
<form:form action="additemtofoodorder" modelAttribute="itemobj">
	Name:<form:input path="name" value="<%=i.getName()%>" readonly="true"/><br>
	Type:<form:input path="type" value="<%=i.getType()%>" readonly="true"/><br>
	Cost:<form:input path="cost" value="<%=i.getCost()%>" readonly="true"/><br>
	Quantity:<form:input path="quantity"/><br>
<input type="submit">
</form:form>



</body>
</html>