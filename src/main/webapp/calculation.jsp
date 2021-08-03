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
</head>
<body>
<form action="/test" method="post">
    <input type="number" name="num1" placeholder="Number 1" required step="0.01">
    <input type="number" name="num2" placeholder="Number 2" required step="0.01">
    <select name="operation" size="?" required>
        <option value="add">Addition</option>
        <option value="sub">Subtraction</option>
        <option value="mul">Multiplication</option>
        <option value="div">Division</option>
    </select>
    <button>Count</button>
</form>
<p>Result : ${requestScope.operation}</p>
<p>${requestScope.incorrect}</p>
<form action="/reg" method="get">
    <button>Registration</button>
</form>
<form action="/logout" method="get">
    <button>Exit</button>
</form>
<form action="/history">
    <button>Get history</button>
</form>
</body>
</html>
