<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<div container>
    <div class="error">
        <h3 style="color: red; font-weight: bold">${error}</h3>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
