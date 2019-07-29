<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="header.jsp" %>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <fmt:setLocale value="${sessionScope.localization}"/>
    <fmt:setBundle basename="locale/localization"/>
    <fmt:message key="local.toHome" var="homePage"/>
    <fmt:message key="local.email" var="email"/>
    <fmt:message key="local.signIn" var="signIn"/>
    <fmt:message key="local.password" var="password"/>
    <fmt:message key="local.remember" var="remember"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <form id="form-signin" action="controller">
                <input type="hidden" name="command" value="login"/>
                <div id="wrapper">
                    <h2 class="form-signin-heading">${signIn}</h2>
                    <label for="inputEmail" class="sr-only">${email}</label>
                    <input type="email" id="inputEmail" name="email"
                           pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3})|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$"
                           title="Please enter valid email form." class="form-control mb-1" placeholder="${email}"
                           required autofocus>
                    <label for="inputPassword" class="sr-only">${password}</label>
                    <input type="password" id="inputPassword" name="password" class="form-control mb-1"
                           placeholder="${password}" required>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> ${remember}
                        </label>
                    </div>
                    <div id="error_message"></div>
                    <button id="submit_button" class="btn btn-lg btn-primary btn-block">${signIn}</button>
                </div>
            </form>
            <a href="/" class="btn btn-lg btn-primary btn-block signup-btn">
                ${homePage}
            </a>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script
        src="https://code.jquery.com/jquery-migrate-3.0.1.min.js"
        integrity="sha256-F0O1TmEa4I8N24nY0bya59eP6svWcshqX1uzwaWC4F4="
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/jquery-ui.min.js"
        crossorigin="anonymous"></script>
<script src="resources/js/login.js"></script>
</body>
</html>
