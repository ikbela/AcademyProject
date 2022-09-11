<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/31/2022
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css " rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css " rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/SalesStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Purchase Table</title>
</head>
<body class="table-wrapper">

    <table class="fl-table">
        <thead>
        <tr>
            <td class="text-center" colspan="4"><h2 style="color: black">Products minor 10000</h2></td>
        </tr>
        <tr>
            <th>Name</th>
            <th>Discription</th>
            <th>Date</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allProducts}" var="product">
            <tr>

                <td> ${product.name}</td>
                <td>${product.description}</td>
                <td><fmt:formatDate value="${product.createdAt}" pattern="yyyy-MM-dd" /></td>
                <td>${product.price}</td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div class="d-flex justify-content-around">
        <a href="/product/base64" class="d-flex justify-content-center" style="color: black">Click here to base64 code</a>
        <a href="/showFiles" class="btn fa fa-angle-left" style="font-size:48px;color:red"></a>
    </div>



</body>
</html>
