<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Page</title>
    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
</head>
<body>
<div>
    <div class="topOfPage">
        <div class="p-3">
            <div class="d-flex align-items-center justify-content-between ">
                <div class="d-md-inline-flex align-items-center  justify-content-between ">
                    <h2>Welcome, <c:out value="${currentUser.firstName}"></c:out></h2>

                    <a href="/showFiles" class="mx-2">
                        <button class="btn btn-secondary">Show All Files</button>
                    </a>
                </div>
                <form id="logoutForm" method="POST" action="/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="Log out" class="btn btn-danger"/>
                </form>
            </div>
        </div>
    </div>
<div class="container">
    <c:if test="${currentUser.roles.get(0).name.contains('ROLE_ADMIN')}">
        <table class="table table-striped ">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <c:if test="${!user.roles.get(0).name.contains('ROLE_SUPER_ADMIN')}">
                    <tr>
                        <td>${user.firstName} ${user.lastName}</td>
                        <td>${user.email}</td>

                        <c:if test="${user.roles.get(0).name.contains('ROLE_ADMIN')}">
                            <td>Admin</td>
                        </c:if>
                        <c:if test="${user.roles.get(0).name.contains('ROLE_USER')}">
                            <td><a href="/delete/${user.id}">Delete</a> <a href="/admin/${user.id}">Make Admin</a></td>
                        </c:if>

                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</div>
</body>
</html>
