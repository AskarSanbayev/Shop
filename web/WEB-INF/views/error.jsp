
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
<%@ include file="/index.jsp" %>
<div class="error">
    <h2 style="color: red; font-weight: bold">${errorMsg}</h2>
    <h3 style="color: red; font-weight: bold">${error}</h3>
</div>
</body>
</html>
