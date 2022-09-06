<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/style.css">
    <title>Display String</title>
</head>
<body>
<div class="container">
    <textarea>${displayString} </textarea>
</div>
<%--<script >
   const base64Data =${displayString};
    const base64 = await fetch(base64Data);
    const base64Response = await fetch(`data:image/jpeg;base64,${base64Data}`);
    const blob = await base64Response.blob();
console.log(blob);
</script> --%>

</body>
</html>