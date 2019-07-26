<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp" %>
    <fmt:setLocale value="${sessionScope.localization}"/>
    <fmt:setBundle basename="locale/localization"/>
    <fmt:message key="local.toHome" var="homePage"/>
    <fmt:message key="local.success" var="success"/>
    <fmt:message key="local.logIn" var="login"/>
    <fmt:message key="local.password" var="password"/>
    <fmt:message key="local.email" var="email"/>
</head>
<body>
<div class="container">
    <div class=" row">
        <div class="col-md-5">
            <h3 class="text-success font-weight-bold mt-1">${success}</h3>
            <p class="font-weight-bold">${email}: ${user.email}</p>
            <p class="font-weight-bold">${password}: ${user.password}</p>

            <a href="controller?command=to_login" class="btn btn-lg btn-primary btn-block signup-btn mb-1">
                ${logIn}
            </a>
            <a href="/" class="btn btn-lg btn-primary btn-block signup-btn">
                ${homePage}
            </a>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
