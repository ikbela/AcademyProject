<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Dashboard</title>
</head>
<body>


    <h1>Hello ${currentUser.fistName}</h1>
    <div>
        <a href="/">Home</a>
        <form id="logoutForm" method="POST" action="/logout" class="button btn-primary">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Logout!"/>
        </form>

    </div>
    <form action="/upload" method="post" enctype="multipart/form-data" >
        <h5>Select file: </h5>
        <input type="file" name="url"/>


        <%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        <div>
            <input type="submit" value="Submit" class="button btn-primary">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <div>

    </div>






</body>
</html>
