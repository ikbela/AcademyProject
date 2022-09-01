<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body class="container">
<div>
    <p> Welcome Admin</p>

    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" class="btn btn-primary"/>
    </form>

</div>
<h1>Welcome to the Admin Page <c:out value="${currentUser.fistName}"></c:out></h1>
<div class="text-center">


    <c:if test="${currentUser.roles.get(0).name.contains('ROLE_SUPER_ADMIN')}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td> ${user.fistName} ${user.lastName}</td>
                    <td>${user.email}</td>
                    <c:if test="${user.roles.get(0).name.contains('ROLE_ADMIN')}">
                        <td>Admin <a href="/delete/${user.id}">Delete</a></td>
                    </c:if>
                    <c:if test="${user.roles.get(0).name.contains('ROLE_USER')}">
                        <td><a href="/delete/${user.id}" style="color: orangered">Delete</a> <a href="/admin/${user.id}" style="color: cyan">Make Admin</a></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
    <c:if test="${currentUser.roles.get(0).name.contains('ROLE_ADMIN')}">
        <table>
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
                        <td>${user.fistName} ${user.lastName}</td>
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
</body>
</html>
