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

<div class="panel-heading">
    <br>
    <h1 class="text-center">All Purchases</h1>
    <br>
    <a href="/purchase/convertPDF" class="btn-outline-dark text-center h3 col-md-12 float-left-top2 "> Encoded
        Table</a>

</div>

<!-- Table with panel -->
<div class="card card-cascade narrower">
    <!--Card image-->
    <div
            class="view view-cascade gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">

    </div>
    <!--/Card image-->

    <div class="px-4">

        <div class="table-wrapper">
            <!--Table-->
            <table class="table table-hover mb-0">

                <!--Table head-->
                <thead class="table-dark">
                <tr>
                    <th class="th-lg">
                        Product
                        <i class="fas fa-sort ml-1"></i>
                    </th>
                    <th class="th-lg">
                        Description
                        <i class="fas fa-sort ml-1"></i>
                    </th>
                    <th class="th-lg">
                        Date
                        <i class="fas fa-sort ml-1"></i>

                    </th>
                    <th class="th-lg">
                        Price
                        <i class="fas fa-sort ml-1"></i>
                    </th>

                </tr>
                </thead>
                <!--Table head-->

                <!--Table body-->
                <tbody>
                <c:forEach items="${lastWeekPurchases}" var="purchase">
                    <tr>

                        <td><c:out value="${purchase.product}"></c:out></td>
                        <td><c:out value="${purchase.description}"></c:out></td>
                        <td><fmt:formatDate value="${purchase.createdAt}" pattern="yyyy-MM-dd"/></td>
                        <td><c:out value="${purchase.price}"></c:out></td>
                    </tr>
                </c:forEach>

                </tbody>
                <!--Table body-->
                <tfoot>
                <td> Total:</td>
                <td>${totalPrice}</td>
                </tfoot>
            </table>
            <!--Table-->
        </div>

    </div>

</div>
<!-- Table with panel -->
</body>
</html>