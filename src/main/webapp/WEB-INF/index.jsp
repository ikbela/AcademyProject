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
<html>
<head>
    <title>Sales Table</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>


<table class="table table-striped table-bordered">
    <tr>
        <th>Sales Table</th>
    </tr>
    <tr class="table-dark">
        <th>Product</th>
        <th>Buyer</th>
        <th>Date</th>
        <th>Price</th>

    </tr>
    <c:forEach items="${allSalesOfLastWeek}" var="sale">
        <tr>

            <td><c:out value="${sale.product.name}"></c:out></td>
            <td><c:out value="${sale.buyer}"></c:out></td>
            <td><c:out value="${sale.createdAt}"></c:out></td>
            <td><c:out value="${sale.price}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
