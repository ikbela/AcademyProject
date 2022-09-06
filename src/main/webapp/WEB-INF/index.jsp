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
</head>
<body>

<div class="container d-flex flex-column align-content-center m-lg-5">
    <table class="table table-striped table-bordered">
        <thead>
        <h3 class="text-center">Sales Table</h3>
        </thead>
        <tbody>
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
                <td> <fmt:formatDate value="${sale.createdAt}" pattern="yyyy-MM-dd" /></td>
                <td><c:out value="${sale.price}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>

        <tfoot>
        <td>Total</td>
        <td></td>
        <td></td>
        <td><c:out value="${total}"></c:out></td>
        </tfoot>

    </table>


    <hr>
    <a href="/getPdf" class="d-flex justify-content-center" style="color: black"> Click here to base64 code</a>

</div>

</body>
</html>
