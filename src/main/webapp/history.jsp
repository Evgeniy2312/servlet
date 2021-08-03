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
<body>
<form action="/history" method="post">
    <select name="name"  size="?">
        <option value="add">Addition</option>
        <option value="sub">Subtraction</option>
        <option value="mul">Multiplication</option>
        <option value="div">Division</option>
    </select>
    <button>History by type of operation</button>
</form>
<form action="/history" method="post">
    <input type="text" name="login" placeholder="Login of user" required>
    <button>History by login</button>
</form>
<form action="/history" method="post">
    <button>The whole history</button>
</form>
<form action="/test" method="get">
    <button>Back to calculation</button>
</form>
<table bgcolor="#7fffd4" border="2">
    <tr>
        <th>Number 1</th>
        <th>Number 2</th>
        <th>Operation</th>
        <th>Login</th>
        <th>Result</th>
    </tr>
    <c:forEach var ="operations" items="${requestScope.list}">
        <tr>
            <td>${operations.i1}</td>
            <td>${operations.i2}</td>
            <td>${operations.operation}</td>
            <td>${operations.user.login}</td>
            <td>${operations.result}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
