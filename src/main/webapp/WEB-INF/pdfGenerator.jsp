<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>PDF generated page</title>
</head>
<body>
<div>
    <embed src="data:application/pdf;base64,${generate}" type="application/pdf" width="100%" height="800px"/>
</div>
</body>
</html>