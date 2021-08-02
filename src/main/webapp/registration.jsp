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
</head>
<body>
<form action="/reg" method="post">
    <input type="text" name="login" placeholder="Login">
    <input type="text" name="password" placeholder="Password">
    <button>Registration</button>
</form>
<p>${requestScope.user} </p>
<form action="/auth" method="post">
    <input type="text" name="login" placeholder="Login" required>
    <input type="text" name="password" placeholder="Password" required>
    <button>Log in</button>
</form>
<p>${requestScope.incorrectData}</p>
</body>
</html>
