<%@ page import="by.Matveev.entity.Operation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 28.07.2021
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="calculation.css">
</head>
<body>
<h1 align="center">History</h1>
<form action="/history" align="center">
    <select name="name">
        <option selected disabled>Choose the function</option>
        <option value="add">Addition</option>
<%--        name == value--%>
        <option value="sub">Subtraction</option>
        <option value="mul">Multiplication</option>
        <option value="div">Division</option>
    </select>
    <button type="submit">History by type of operation</button>
</form>
<a href="/calc">Back to calculation</a>
<ul class="my-list">
    <c:forEach var ="operations" items="${requestScope.list}">
        <li class="my-item">${operations}</li>
    </c:forEach>
</ul>
</body>
</html>
