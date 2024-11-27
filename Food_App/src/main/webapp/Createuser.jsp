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
<form:form action="saveuser" modelAttribute="users">

Enter Name:<form:input path="name"/>
Enter Email:<form:input path="email"/>
Enter Password:<form:input path="password"/>
Enter Mobilenumber:<form:input path="mobilenumber"/>


<input type="submit">

</form:form>
</body>
</html>