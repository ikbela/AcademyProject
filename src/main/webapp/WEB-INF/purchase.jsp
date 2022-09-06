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
    <title>Purchase Table</title>
</head>
<body>
<div class="container">
    <div class="panel-heading">
        <h3>All Purchases</h3>
    </div>

    <div class="panel-body">
        <table class="table table-striped table-dark">
            <thead class="table-dark">

            <tr>
                <th width="20%">Product</th>
                <th width="20%">Description</th>
                <th width="20%">Date</th>
                <th width="20%">Price</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${lastWeekPurchases}" var="purchase">
            <tr>

                <td><c:out value="${purchase.product}"></c:out></td>
                <td><c:out value="${purchase.description}"></c:out></td>
                <td><fmt:formatDate value="${purchase.createdAt}" pattern="yyyy-MM-dd"/></td>
                <td><c:out value="${purchase.price}"></c:out></td>
            </tr>
            </c:forEach>
            <tfoot>
            <td> Total:</td>
            <td>${totalPrice}</td>
            </tfoot>
        </table>
    </div>
</div>
<a href="/convertPDF" class="btn-outline-success text-center"> Click here to get pdf file</a>

</body>
</html>