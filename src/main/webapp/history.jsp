<%@ page import="by.Matveev.entity.Operation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 28.07.2021
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>History by user</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1 align="center" class="display-5 mb-3">Your history</h1>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-6">
            <form action="/history2">
                <div class="mb-3">
                    <label for="selectOperation" class="form-label">Select function</label>
                    <select name="name" id="selectOperation" class="form-select">
                        <option value="add">Addition</option>
                        <option value="sub">Subtraction</option>
                        <option value="mul">Multiplication</option>
                        <option value="div">Division</option>
                    </select>
                    <button type="submit" class="btn btn-primary my-3">Get</button>
                </div>
            </form>
            <div class="list-group mb-5">
                <c:forEach items="${requestScope.currentList}" var="operation">
                    <a href="#" class="list-group-item list-group-item-action list-group-item-primary">${operation}</a>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-sm-6">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <c:if test="${requestScope.currentPage != 1}">
                            <a class="page-link" href="/history2?currentPage=${requestScope.currentPage - 1}">Previous</a>
                        </c:if>
                    </li>
                    <c:forEach begin="1" end="${requestScope.numPages}" var="i">
                    <c:choose>
                    <c:when test="${requestScope.currentPage eq i}">
                        <li class="page-item disabled">
                            <a class="page-link">${i}</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                    <li class="page-item"><a href="/history2?currentPage=${i}"
                                             class="page-link">${i}</a>
                        </c:otherwise>
                        </c:choose>
                        </c:forEach>
                    </li>
                    <li class="page-item">
                        <c:if test="${requestScope.currentPage lt requestScope.numPages}">
                    <li class="page-item">
                        <a href="/history2?currentPage=${currentPage + 1}" class="page-link">Next</a>
                    </li>
                    </c:if>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>


<%--<h1 align="center">History</h1>--%>
<%--<form action="/history" align="center">--%>
<%--    <select name="name">--%>
<%--        <option selected disabled>Choose the function</option>--%>
<%--        <option value="add">Addition</option>--%>
<%--&lt;%&ndash;        name == value&ndash;%&gt;--%>
<%--        <option value="sub">Subtraction</option>--%>
<%--        <option value="mul">Multiplication</option>--%>
<%--        <option value="div">Division</option>--%>
<%--    </select>--%>
<%--    <button type="submit">History by type of operation</button>--%>
<%--</form>--%>
<%--<a href="/calc">Back to calculation</a>--%>
<%--<ul>--%>
<%--    <c:forEach var ="operations" items="${requestScope.list}">--%>
<%--        <li >${operations}</li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>
