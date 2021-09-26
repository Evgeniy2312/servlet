<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 08.09.2021
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Addresses</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1 align="center" class="display-5 mb-3">Your addresses</h1>
<div class="container">
    <div class ="row justify-content-center">
        <div class="col-sm-6">
            <ol class="list-group list-group-numbered">
                <c:forEach items="${requestScope.addressesList}" var="address">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">${address.street}</div>
                        ${address.number}
                    </div>
                    <span class="badge bg-primary rounded-pill"><a class="page-link"
                                                                   href="/updateAddress?id=${address.id}">Update</a></span>
                    <span class="badge bg-primary rounded-pill"><a class="page-link"
                                                                   href="/deleteAddress?id=${address.id}">Delete</a></span>
                </li>
                </c:forEach>
            </ol>
            <c:if test="${requestScope.message != null}">
                <div class="alert alert-secondary" role="alert">
                    ${requestScope.message}
                </div>
            </c:if>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-sm-3 m3 rounded">
            <a href="/addAddress" class="btn btn-primary m-3">Add new address</a>
        </div>
    </div>
</div>
</body>
</html>
