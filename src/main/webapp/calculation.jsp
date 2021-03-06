<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 28.07.2021
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculation</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <form action="/calc" method="post">
                <fieldset>
                    <div class="mb-3">
                        <input required name="numbers" type="number" class="form-control" placeholder="Number 1" step="0.01">
                    </div>
                    <div class="mb-3">
                        <input required name="numbers" type="number" class="form-control" placeholder="Number 2" step="0.01">
                    </div>
                    <div class="mb-3">
                        <label for="selectOperation" class="form-label">Select function</label>
                        <select name="type" id="selectOperation" class="form-select">
                            <option value="add">Addition</option>
                            <option value="sub">Subtraction</option>
                            <option value="mul">Multiplication</option>
                            <option value="div">Division</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Count</button>
                </fieldset>
            </form>
            <c:if test="${requestScope.message != null}">
                <div class="alert alert-primary" role="alert">
                        ${requestScope.message}
                </div>
            </c:if>
            <c:if test="${requestScope.result != null}">
            <div class="alert alert-info" role="alert" step="0.01">
                Result: ${requestScope.result}
            </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>


<%--<h1 align="center">Calculation</h1>--%>
<%--<form align="center" action="/calc" method="post">--%>
<%--    <input type="number" name="num1" placeholder="Number 1" required step="0.01">--%>
<%--    <input type="number" name="num2" placeholder="Number 2" required step="0.01">--%>
<%--    <select name="operation" size="?" required>--%>
<%--        <option value="add">Addition</option>--%>
<%--        <option value="sub">Subtraction</option>--%>
<%--        <option value="mul">Multiplication</option>--%>
<%--        <option value="div">Division</option>--%>
<%--    </select>--%>
<%--    <button type="submit">Count</button>--%>
<%--</form>--%>
<%--<p align="center">Result : ${requestScope.operation}</p>--%>
<%--<p align="center">${requestScope.incorrect}</p>--%>
<%--<a href="/logout">Exit</a>--%>
<%--<a href="/history">Get history</a>--%>
