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
</head>
<body background="https://profotovideo.ru/images/2018/03/14-oilphoto/oilphoto02.jpg">
<h1 align="center">History</h1>
<form action="/history" align="center">
    <select name="name"  size="?">
        <option value="add">Addition</option>
        <option value="sub">Subtraction</option>
        <option value="mul">Multiplication</option>
        <option value="div">Division</option>
    </select>
    <button type="submit">History by type of operation</button>
</form>
<p align="center"><button onclick='location.href="/calc"'>Back to calculation</button></p>
<p align="center"><table bordercolor="blue"  bgcolor="#ffe4c4" border="2">
    <tr>
        <th>Number 1</th>
        <th>Number 2</th>
        <th>Operation</th>
        <th>Name</th>
        <th>Result</th>
    </tr>
    <c:forEach var ="operations" items="${requestScope.list}">
        <tr>
            <td>${operations.i1}</td>
            <td>${operations.i2}</td>
            <td>${operations.operation}</td>
            <td>${operations.user.name}</td>
            <td>${operations.result}</td>
        </tr>
    </c:forEach>
</table>
</p>
</body>
</html>
