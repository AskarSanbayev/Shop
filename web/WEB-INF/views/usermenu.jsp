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
    <link type="text/css" rel="stylesheet" href="resources/css/menu.css"/>
    <fmt:setLocale value="${sessionScope.localization}"/>
    <fmt:setBundle basename="locale/localization"/>
    <fmt:message key="local.home" var="home"/>
    <fmt:message key="local.logOut" var="logOut"/>
    <fmt:message key="local.cart" var="cart"/>
    <fmt:message key="local.balance" var="balance"/>
    <fmt:message key="local.code" var="code"/>
    <fmt:message key="local.productname" var="productname"/>
    <fmt:message key="local.price" var="price"/>
    <fmt:message key="local.addtocart" var="addtocart"/>
    <fmt:message key="local.amount" var="amount"/>
    <fmt:message key="local.add" var="add"/>
    <fmt:message key="local.orderhistory" var="orderhistory"/>

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
                    <a class="nav-link" href="controller?command=user_menu">${home}<span
                            class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=logout">${logOut}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=to_cart">${cart}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=to_order_history">${orderhistory}</a>
                </li>
                <li class="nav-item">
                    <p class="nav-link">${balance} : ${accountbalance}</p>
                </li>
            </ul>
        </div>
    </nav>
    <div class="list-wrapper">
        <c:forEach var="product" items="${sessionScope.productlist}">
            <div class="list-item">
                <div class="row">
                    <div class="col-md-4 h-30 p-3">
                        <img src="resources/image/${product.code}.png" class="img-thumbnail" alt="">
                    </div>
                    <div class="col-md-2 h-20 p-3">
                            ${code} : <c:out value="${product.code}"/>
                            ${productname}:<c:out value="${product.name}"/>
                            ${price}:<c:out value="${product.price}"/>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <div id="pagination-container"></div>
        </div>
        <div class="col-md-5 pb-10">
            <form id="form-add" action="controller">
                <input type="hidden" name="command" value="add_to_cart"/>
                <div id="wrapper">
                    <h4 class="form-signin-heading">${addtocart}</h4>
                    <div class="row">
                        <div class="col-md-6">
                            <label for="code" class="sr-only">${code}</label>
                            <input type="code" id="code" name="code"
                                   pattern="^[0-9]*$"
                                   title="Please enter valid number." class="form-control mb-1" placeholder="${code}"
                                   required autofocus>
                        </div>
                        <div class="col-md-6">
                            <label for="amount" class="sr-only">${amount}</label>
                            <input type="amount" id="amount" name="amount" class="form-control mb-1"
                                   pattern="^[0-9]*$" title="Please enter valid number."
                                   placeholder="${amount}" required>
                        </div>
                    </div>
                    <div id="error_message">${errormessage}</div>
                    <button id="submitter" class="btn btn-lg btn-primary btn-block" type="submit">${add}</button>
                </div>
            </form>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/simplePagination.js/1.6/jquery.simplePagination.js"
        crossorigin="anonymous"></script>
<script src="resources/js/menu.js"></script>
</body>
</html>
