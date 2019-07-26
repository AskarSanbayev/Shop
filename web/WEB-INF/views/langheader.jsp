<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.5/css/mdb.min.css" rel="stylesheet">
    <fmt:setLocale value="${sessionScope.localization}"/>
    <fmt:setBundle basename="locale/localization"/>
    <fmt:message key="local.home" var="home"/>
    <fmt:message key="local.register" var="register"/>
    <fmt:message key="local.logIn" var="logIn"/>
    <fmt:message key="local.en" var="en"/>
    <fmt:message key="local.ru" var="ru"/>
</head>
<body>
<div class="container ">
    <nav class="navbar navbar-expand-lg navbar-dark primary-color">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/">${home}<span
                            class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=to_login">${logIn}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=to_register">${register}</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item">
                    <a class="nav-link waves-effect waves-light"
                       href="controller?command=change_locale&localization=en">
                        ${en}
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect waves-light"
                       href="controller?command=change_locale&localization=ru">
                        ${ru}
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>
</body>
</html>
