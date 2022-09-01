<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Page</title>


</head>
<body>
<div>
    <h1>Register!</h1>
    <p><form:errors path="user.*"/></p>
    <%--@elvariable id="user" type="java"--%>
    <form:form method="POST" action="/registration/user" modelAttribute="user">
        <p>
            <form:label path="email">Email:</form:label>
            <form:input path="email"/>
        </p>
        <p>
            <form:label path="fistName">First Name:</form:label>
            <form:input path="fistName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register!" class="button btn-primary"/>
    </form:form>
    <a href="/login">Login!</a>
</div>

</body>
</html>
