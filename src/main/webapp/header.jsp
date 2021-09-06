<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 16.08.2021
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Header</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
</head>
<body>
<header class="p-3 bg-dark text-white mb-5">
    <div class="container">
        <ul class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/home" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <a class="navbar-brand" href="/home">Calculator</a>
            </a>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <c:if test="${sessionScope.user == null}">
                    <li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello
                        guest!</a></li>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <li><a href="/calc" class="nav-link px-2 text-white">Count</a></li>
                    <li><a href="/history2" class="nav-link px-2 text-white">History</a></li>
                </c:if>
            </ul>
            <c:if test="${sessionScope.user == null}">
                <div class="text-end">
                    <button type="button" onClick="location.href='/reg'" class="btn btn-outline-light me-2">Login
                    </button>
                    <button type="button" onClick="location.href='/auth'" class="btn btn-warning">Sign-up</button>
                </div>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <div class=" d-flex justify-content-end ">
                    <div class="dropdown text-end  ">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2"
                                data-bs-toggle="dropdown"
                                aria-expanded="false">
                                ${sessionScope.user.name}
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <li>
                                <button class="dropdown-item" type="button" onClick="location.href='/change'">Change
                                    password
                                </button>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <button class="dropdown-item" type="button" onClick="location.href='/logout'">Exit
                                </button>
                            </li>
                        </ul>
                    </div>
                </div>
            </c:if>
        </ul>
    </div>
</header>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>


<%--<nav class="navbar navbar-expand-lg navbar-light bg-light mb-5" >--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand" href="/home">Calculator</a>--%>
<%--        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="collapse navbar-collapse" id="navbarNav">--%>
<%--            <ul class="navbar-nav">--%>
<%--                <c:if test="${sessionScope.user == null}">--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello guest!</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/reg">Registration</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/auth">Authorization</a>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
<%--                <c:if test="${sessionScope.user != null}">--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello ${sessionScope.user.name}!</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/calc">Count</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/history">History</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/logout">Exit</a>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>


<%--                    <li><a href="/reg" class="nav-link px-2 text-secondary">Registration</a></li> ссылки для header--%>
<%--                 <li><a href="/auth" class="nav-link px-2 text-white" >Authorization</a></li>--%>




