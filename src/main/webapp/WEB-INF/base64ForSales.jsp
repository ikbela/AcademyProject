<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/2/2022
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Base 64 for sales</title>

    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/SalesStyle.css">
</head>
<body>

<div class="container d-flex flex-column">
<%--    <textarea class="text-area" cols="40" rows="20"> <c:out value="${model}"></c:out></textarea>--%>

<%--    <div class="form-group shadow-textarea">--%>
<%--        <textarea class="form-control z-depth-1" id="exampleFormControlTextarea6" rows="17" placeholder="Write something here..."> <c:out value="${model}"></c:out></textarea>--%>
<%--    </div>--%>

    <div class="md-form amber-textarea active-amber-textarea-2">
        <label for="form24" style="color: #3498db;" class="text-center m-lg-5">Base64 Source code</label>
        <i class="fas fa-pencil-alt prefix"></i>
        <textarea id="form24" class="md-textarea form-control" rows="17" style="box-shadow: black 2px 2px 30px"> <c:out value="${model}"></c:out></textarea>
    </div>


    <div class="d-flex justify-content-sm-between m-lg-5">
        <a href="/pdfPageHere" style="color: rgba(236,13,16,0.98)" class="d-flex justify-content-center"> get pdf</a>
        <a href="/SalesPage" style="color: green" class="d-flex justify-content-center">Go back</a>
    </div>

    <%--    new here--%>
<%--    <a href="/pdfPageHere" style="color: rgba(236,13,16,0.98)" class="d-flex justify-content-center"> get pdf</a>--%>
</div>


<script type="text/javascript" src="/doScript.js"> </script>

</body>
</html>
