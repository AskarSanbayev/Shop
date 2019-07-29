<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.07.2019
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.5/css/mdb.min.css" rel="stylesheet">
    <fmt:setLocale value="${sessionScope.localization}"/>
    <fmt:setBundle basename="locale/localization"/>
    <fmt:message key="local.home" var="home"/>
    <fmt:message key="local.logOut" var="logOut"/>
    <fmt:message key="local.cart" var="cart"/>
    <fmt:message key="local.balance" var="balance"/>
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
                    <a class="nav-link" href="controller?command=usermenu">${home}<span
                            class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=logout">${logOut}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=to_cart">${cart}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">${balance} : ${accountbalance}</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
