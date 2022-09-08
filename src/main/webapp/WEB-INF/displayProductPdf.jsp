<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/SalesStyle.css">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Base 64 for sales</title>
</head>
<body>
<div class="container d-flex flex-column">
    <div class="md-form amber-textarea active-amber-textarea-2">
        <label for="form24" style="color: #3498db;" class="text-center m-lg-5">Base64 Source code</label>
        <i class="fas fa-pencil-alt prefix"></i>
        <textarea id="form24" class="md-textarea form-control" rows="17" style="box-shadow: black 2px 2px 30px"> ${displayString}</textarea>
    </div>

    <div class="d-flex justify-content-sm-between m-lg-5">
        <a href="/product/get-pdf" class="btn fa fa-file-pdf-o m-lg-2 " style="font-size:50px;color:green;"></a>
        <a href="/product" class="btn fa fa-angle-left" style="font-size:48px;color:red"></a>
    </div>

</div>
<script type="text/javascript" src="/doScript.js"> </script>
</body>
</html>