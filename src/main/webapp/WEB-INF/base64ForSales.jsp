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
</head>
<body>


    <textarea class="text-area" cols="100" rows="40"> <c:out value="${model}"></c:out></textarea>


<div>
    <button id="decode">Decode</button>
    <button id="encode">Encode</button>
</div>

    <p>
        <a href="https://base64.guru/converter/decode/pdf">Copy text from textare and go and get pdf file preview :)</a>

    </p>

<script type="text/javascript" src="/doScript.js"> </script>

</body>
</html>
