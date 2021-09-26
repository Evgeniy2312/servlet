<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 10.09.2021
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Telephones</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1 align="center" class="display-5 mb-3">Your telephones</h1>
<div class="container">
    <div class ="row justify-content-center">
        <div class="col-sm-6">
            <ol class="list-group list-group-numbered">
                <c:forEach items="${requestScope.telephoneList}" var="telephone">
                    <li class="list-group-item d-flex justify-content-between align-items-start">
                        <div class="ms-2 me-auto">
                            <div class="fw-bold">${telephone.number}</div>
                        </div>
                        <span class="badge bg-primary rounded-pill"><a class="page-link"
                                                                       href="/updateTelephone?id=${telephone.id}">Update</a></span>
                        <span class="badge bg-primary rounded-pill"><a class="page-link"
                                                                       href="/deleteTelephone?id=${telephone.id}">Delete</a></span>
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
            <a href="/addTelephone" class="btn btn-primary m-3">Add new telephone</a>
        </div>
    </div>
</div>
</body>
</html>
