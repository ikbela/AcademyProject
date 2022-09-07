<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/31/2022
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Sales Table</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/SalesStyle.css">
</head>
<body>


<h2 style="color: black">Sales Table</h2>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr >
            <th>Product</th>
            <th>Buyer</th>
            <th>Date</th>
            <th>Price</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allSalesOfLastWeek}" var="sale">
        <tr>

            <td><c:out value="${sale.product.name}"></c:out></td>
            <td><c:out value="${sale.buyer}"></c:out></td>
            <td> <fmt:formatDate value="${sale.createdAt}" pattern="yyyy-MM-dd" /></td>
            <td><c:out value="${sale.price}"></c:out></td>
        </tr>
        </c:forEach>

        <tr>
            <td style="color: red; font-family: Algerian">Total</td>
            <td></td>
            <td></td>
            <td style="color: red; font-family: Algerian"><c:out value="${total}"></c:out></td>
        </tr>

        <tbody>
    </table>
</div>
<hr>
<a href="/getPdf" class="d-flex justify-content-center" style="color: black"> Click here to base64 code</a>

<script src="static/doScript.js" type="text/javascript"></script>
</body>

</html>
