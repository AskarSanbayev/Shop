<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.07.2019
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
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
    <fmt:message key="local.orderhistory" var="orderhistory"/>
    <fmt:message key="local.totalprice" var="totalprice"/>
    <fmt:message key="local.delete_order" var="delete_order"/>
    <fmt:message key="local.send_order" var="send_order"/>
    <fmt:message key="local.emptycart" var="cartempty"/>
    <fmt:message key="local.delete_product" var="delete_product"/>
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
    <c:if test="${sessionScope.product_map.size() > 0}">
    <c:forEach items="${sessionScope.product_map}" var="entry">
        ${code}: <c:out value="${entry.key.getCode()}"/>
        ${productname}: <c:out value="${entry.key.getName()}"/> ${amount}: <c:out value="${entry.value}"/> <br/>
    </c:forEach>
        ${totalprice}:${sessionScope.get("price")}

    <div class="row">
        <form id="form-add" action="controller" method="post">
            <input type="hidden" name="command" value="remove_from_cart"/>
            <div class="col-md-6">
                <label for="code" class="sr-only">${code}</label>
                <input type="code" id="code" name="code"
                       pattern="^[0-9]*$"
                       title="Please enter valid number." class="form-control mb-1" placeholder="${code}"
                       required autofocus>
            </div>
            <div id="error_message">${error}</div>
            <div class="col-md-9">
                <button id="submitter" class="btn btn-primary btn-block"
                        type="submit">${delete_product}</button>
            </div>
        </form>
    </div>

    <div class="row">
        <div class="col-md-3"><a href="controller?command=delete_order" class="btn btn-lg btn-primary btn-block">
                ${delete_order}
        </a></div>
        <div id="error_money">${errormoney}</div>
        <div class="col-md-3"><a href="controller?command=send_order"
                                 class="btn btn-lg btn-primary btn-block signup-btn">
                ${send_order}
        </a></div>
        <div>${moneyerror}</div>
    </div>
</div>
</c:if>
<c:if test="${sessionScope.product_map.size() == 0 || sessionScope.product_map == null}">
    ${cartempty}
</c:if>

<%@ include file="footer.jsp" %>
</body>
</html>
