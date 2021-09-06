<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 28.07.2021
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body class="text-center">
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <main class="form-signin">
                <form action="/reg " method="post">
                    <i style="width:20px; height:22px" class="fas fa-calculator"></i>
                    <h1 class="h3 mb-3 fw-normal">Please log</h1>
                    <div class="form-floating">
                        <input required name="login" type="email" class="form-control" id="floatingInput"
                               placeholder="name@example.com">
                        <label for="floatingInput">Email address</label>
                    </div>
                    <div class="form-floating">
                        <input required name="name" type="text" class="form-control" id="floatingName"
                               placeholder="name@example.com">
                        <label for="floatingName">Name</label>
                    </div>
                    <div class="form-floating">
                        <input required name="password" type="password" class="form-control" id="floatingPassword"
                               placeholder="Password">
                        <label for="floatingPassword">Password</label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Log</button>
                </form>
            </main>
            <c:if test="${requestScope.message != null}">
                <div class="alert alert-primary" role="alert">
                        ${requestScope.message}
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
<%--<h1 align="center" a>Registration</h1>--%>
<%--<form action="/reg" method="post" align="center">--%>
<%--    <input type="text" name="name" placeholder="Name">--%>
<%--    <input type="text" name="login" placeholder="Login">--%>
<%--    <input type="password" name="password" placeholder="Password">--%>
<%--    <button type="submit">Registration</button>--%>
<%--</form>--%>
<%--<p align="center">${requestScope.incorrectData}</p>--%>


<%--<div class="container">--%>
<%--    <div class="row justify-content-center">--%>
<%--        <div class="col-sm-4">--%>
<%--            <form action="/reg" method="post">--%>
<%--                <div class="mb-3">--%>
<%--                    <label for="exampleInputEmail" class="form-label">Login</label>--%>
<%--                    <input required name="login" type="email" class="form-control" id="exampleInputEmail"--%>
<%--                           aria-describedby="emailHelp">--%>
<%--                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
<%--                </div>--%>
<%--                <div class="mb-3">--%>
<%--                    <label for="exampleInputName" class="form-label">Name</label>--%>
<%--                    <input required name="name" type="text" class="form-control" id="exampleInputName">--%>
<%--                </div>--%>
<%--                <div class="mb-3">--%>
<%--                    <label for="exampleInputPassword" class="form-label">Password</label>--%>
<%--                    <input required name="password" type="password" class="form-control" id="exampleInputPassword">--%>
<%--                </div>--%>
<%--                <button type="submit" class="btn btn-primary">Submit</button>--%>
<%--            </form>--%>
<%--            <c:if test="${requestScope.message != null}">--%>
<%--                <div class="alert alert-primary" role="alert">--%>
<%--                        ${requestScope.message}--%>
<%--                </div>--%>
<%--            </c:if>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>