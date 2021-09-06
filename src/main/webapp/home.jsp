<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 18.08.2021
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class = "row justify-content-center">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-header">
                    Quote
                </div>
                <div class="card-body">
                    <blockquote class="blockquote mb-0">
                        <p>You can't learn programming with a handheld calculator but you can forget arithmetic.</p>
                        <footer class="blockquote-footer">One famous human - <cite title="Alan Perlis">Alan Perlis.</cite></footer>
                    </blockquote>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
