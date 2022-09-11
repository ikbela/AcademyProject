<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/SalesStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Purchase Table</title>
</head>
<body>

<h2 style="color: black">Purchases Table</h2>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>Product</th>
            <th>Description</th>
            <th>Date</th>
            <th>Price</th>

        </tr>
        </thead>

        <tbody>
        <c:forEach items="${lastWeekPurchases}" var="purchase">
        <tr>

            <td><c:out value="${purchase.product.getName()}"></c:out></td>
            <td><c:out value="${purchase.product.description}"></c:out></td>
            <td><fmt:formatDate value="${purchase.date}" pattern="yyyy-MM-dd"/></td>
            <td><c:out value="${purchase.product.price}"></c:out></td>
        </tr>
        </c:forEach>

        <tr>
            <td style="color: red; font-family: Algerian">Total</td>
            <td></td>
            <td></td>
            <td style="color: red; font-family: Algerian"><c:out value="${totalPrice}"></c:out></td>
        </tr>

        <tbody>
    </table>
</div>
<hr>
<div class="d-flex justify-content-around">
    <a href="/purchase/convertPDF" class="d-flex justify-content-center" style="color: black"> Click here to base64 code</a>
    <a href="/showFiles" class="btn fa fa-angle-left" style="font-size:48px;color:red"></a>
</div>

<script src="static/doScript.js" type="text/javascript"></script>

</body>
</html>