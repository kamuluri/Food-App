<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- import JSTL form tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
    }

    .container {
        max-width: 400px;
        margin: 100px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        color: #333;
    }

    form {
        margin-top: 20px;
    }

    form input[type="text"],
    form input[type="password"] {
        width: 100%;
        padding: 12px 15px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 12px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    .footer {
        margin-top: 20px;
        text-align: center;
        color: #666;
    }

    .error {
        color: red;
        font-size: 0.9em;
        margin-top: 5px;
    }
</style>
<script>
    function validateForm() {
        var name = document.forms["registrationForm"]["name"].value;
        var email = document.forms["registrationForm"]["email"].value;
        var password = document.forms["registrationForm"]["password"].value;

        if (name == "" || email == "" || password == "") {
            alert("All fields must be filled out");
            return false;
        }
    }
</script>
</head>
<body>

<div class="container">
    <h2>Register</h2>
    <form:form name="registrationForm" action="saveadmin" modelAttribute="admin" onsubmit="return validateForm()">
        <input type="text" name="name" placeholder="Enter Name">
        <input type="text" name="email" placeholder="Enter Email">
        <input type="password" name="password" placeholder="Enter Password">
        <input type="submit" value="Register">
    </form:form>
    <div class="footer">
        Already have an account? <a href="LoginAdmin.jsp">Login here</a>
    </div>
</div>

</body>
</html>
