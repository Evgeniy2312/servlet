<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 10.09.2021
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add address</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <form action="/addAddress" method="post">
                <i style="width:20px; height:22px" class="fas fa-map"></i>
                <h1 class="h3 mb-3 fw-normal">Please enter the information</h1>
                <div class="form-floating">
                    <input required name="street" type="text" class="form-control" id="floatingStreet"
                           placeholder="Street">
                    <label for="floatingStreet">Street</label>
                </div>
                <div class="form-floating">
                    <input required name="number" type="number" class="form-control" id="floatingNumber"
                           placeholder="Number of the home">
                    <label for="floatingNumber">Number of the home</label>
                </div>
                <button class="w-100 btn btn-lg btn-primary mt-3" type="submit">Add</button>
            </form>
            <c:if test="${requestScope.message != null}">
                <div class="alert alert-secondary" role="alert">
                        ${requestScope.message}
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
