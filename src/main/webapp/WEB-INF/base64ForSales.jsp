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

    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

<div class="container d-flex flex-column">
    <textarea class="text-area" cols="40" rows="20"> <c:out value="${model}"></c:out></textarea>


    <div class="d-flex justify-content-sm-between m-lg-5">
        <button id="decode" class=" btn btn-outline-success">Decode</button>
        <button id="encode" class="btn btn-outline-danger">Encode</button>
    </div>

    <p class="d-flex justify-content-center">
        <a href="https://base64.guru/converter/decode/pdf" style="color: black">Copy text from textarea and go and get pdf file preview :)</a>

    </p>
</div>


<script type="text/javascript" src="/doScript.js"> </script>

</body>
</html>
