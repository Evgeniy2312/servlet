<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 28.07.2021
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="calculation.css">
</head>
<body>
<h1 align="center" a>Registration</h1>
<form action="/reg" method="post" align="center">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="login" placeholder="Login">
    <input type="password" name="password" placeholder="Password">
    <button type="submit">Registration</button>
</form>
<p align="center">${requestScope.incorrectData}</p>
</body>
</html>
