<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
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

    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    form {
        margin-top: 20px;
    }

    input[type="email"],
    input[type="password"] {
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

    .error {
        color: red;
        font-size: 0.9em;
        margin-top: 5px;
        text-align: center;
    }
</style>
<script>
    function validateForm() {
        var email = document.querySelector('input[name="email"]').value;
        var password = document.querySelector('input[name="password"]').value;

        if (email.trim() === "") {
            document.querySelector('.error').textContent = "Please enter your email.";
            return false;
        }

        if (password.trim() === "") {
            document.querySelector('.error').textContent = "Please enter your password.";
            return false;
        }
    }
</script>
</head>
<body>

<div class="container">
    <h1>Login</h1>
    <div class="error">${message}</div>
    <form action="validateAdmin" method="post" onsubmit="return validateForm()">
        Enter email: <input type="email" name="email">
        Enter Password: <input type="password" name="password">
        <input type="submit" value="Login">
    </form>
</div>

</body>
</html>
