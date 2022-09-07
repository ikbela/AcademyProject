<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Uploaded Files</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">

</head>
<body>
<div class="container">
<h3 class="text-center">Files</h3>
<table class="table table-bordered table-striped">
<thead>
<tr class="table-primary text-center">
    <th>Name</th>
    <th>Size</th>
    <th>Extention</th>
    <th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="files" items="${files}">
    <tr class="text-center">
    <td>${files.fileName}</td>
    <td>${files.size} Bytes</td>
    <td>.${files.extention}</td>
    <td>
        <c:if test="${!files.status}">
            <a href="/save/${files.id}" class="btn btn-primary">Save</a>
        </c:if>
        <c:if test="${files.status}">
            <a class="btn btn-secondary disabled">Disabled</a>
        </c:if>

        <c:if test="${currentUser.roles.get(0).name.contains('ROLE_ADMIN')}">
        <a href="#" class="btn btn-danger">Convert</a>
        </c:if>
    </td>
    </tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>
