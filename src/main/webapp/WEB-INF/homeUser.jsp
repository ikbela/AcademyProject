<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome Page</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/styleMain.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <!-- Bootstrap Font Icon CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

</head>
<body style="background: #d8dcf3">
<%--Top of Page--%>
<div class="topOfPage">
    <div class="p-3">
        <div class="d-flex align-items-center justify-content-between ">
            <div class="d-md-inline-flex align-items-center  justify-content-between ">
                <h2>Welcome, <c:out value="${currentUser.firstName}"></c:out></h2>
                <c:if test="${error != null}">
                    <div class="text-success" >
                        <c:out value="${error}"></c:out>
                    </div>
                </c:if>

                <a href="/showFiles" class="mx-2">
                    <button class="btn btn-secondary">Show All Files</button>
                </a>
            </div>
            <form id="logoutForm" method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Log out" class="btn btn-danger"/>
            </form>
        </div>
    </div>
</div>
<div class="card col-sm-4 my-1  container" style="background: #c9cfee">
    <form action="/upload" method="post" enctype="multipart/form-data" >
        <h5 class="m-lg-2">Select a CSV file: </h5>
        <input type="file" name="url" class="form-control"/>

        <div>
            <input type="submit" value="Submit" class="m-lg-3 btn btn-success">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <script language='javascript'>
        <c:if test="${message!=null}">
        window.alert('Success');window.location='/showFiles';
        </c:if>
    </script>

    <script language='javascript'>
        <c:if test="${error!=null}">
        window.alert('File already Exists');window.location='/';
        </c:if>
    </script>


</div>



</body>
</html>
