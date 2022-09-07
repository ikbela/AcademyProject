<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/SalesStyle.css">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/style.css">
    <title>Base 64 for sales</title>
</head>
<body>
<div class="container d-flex flex-column">
    <div class="md-form amber-textarea active-amber-textarea-2">
        <label for="form24" style="color: #3498db;" class="text-center m-lg-5">Base64 Source code</label>
        <i class="fas fa-pencil-alt prefix"></i>
        <textarea id="form24" class="md-textarea form-control" rows="17" style="box-shadow: black 2px 2px 30px"> <c:out value="${displayString}"></c:out></textarea>
    </div>

    <div class="d-flex justify-content-sm-between m-lg-5">
        <a href="/purchase/generatePDF" style="color: rgba(236,13,16,0.98)" class="d-flex justify-content-center"> get pdf</a>
        <a href="/purchase" style="color: green" class="d-flex justify-content-center">Go back</a>
    </div>

</div>
<script type="text/javascript" src="/doScript.js"> </script>
</body>

</html>