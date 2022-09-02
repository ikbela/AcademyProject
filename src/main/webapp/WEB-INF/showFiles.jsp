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
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Size</th>
        <th>Extention</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${files}" var="files">
        <tr>
            <td>${files.url}</td>
            <td>${files.size}</td>
            <td>${files.extention}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
