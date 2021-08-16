<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 28.07.2021
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation</title>
    <link rel="stylesheet" href="calculation.css">
</head>
<body>
<h1 align="center">Calculation</h1>
<form align="center" action="/calc" method="post">
    <input type="number" name="num1" placeholder="Number 1" required step="0.01">
    <input type="number" name="num2" placeholder="Number 2" required step="0.01">
    <select name="operation" size="?" required>
        <option value="add">Addition</option>
        <option value="sub">Subtraction</option>
        <option value="mul">Multiplication</option>
        <option value="div">Division</option>
    </select>
    <button type="submit">Count</button>
</form>
<p align="center">Result : ${requestScope.operation}</p>
<p align="center">${requestScope.incorrect}</p>
<a href="/logout">Exit</a>
<a href="/history">Get history</a>
</body>
</html>
