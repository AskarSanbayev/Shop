<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.07.2019
  Time: 12:52
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
    <fmt:message key="local.delete_order" var="delete"/>
    <fmt:message key="local.send_order" var="order"/>
    <fmt:message key="local.emptycart" var="cartempty"/>
    <fmt:message key="local.delete_product" var="delete_product"/>
    <fmt:message key="local.history_empty" var="history_empty"/>
    <fmt:message key="local.order_name" var="ordername"/>
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
    <c:if test="${sessionScope.orderhistory.size() > 0}">
        <c:forEach items="${sessionScope.orderhistory}" var="entry">
            <c:if test="${sessionScope.order_id != entry.key.getOrderId()}">
                <p>${ordername}:</p>
                ${totalprice}: <c:out value="${entry.key.getPrice()}"/> <br/>
                <c:forEach items="${entry.value}" var="inner">
                    ${code}: <c:out value="${inner.key.getCode()}"/> <br/>
                    ${productname}: <c:out value="${inner.key.getName()}"/> <br/>
                    ${amount}: <c:out value="${inner.value}"/> <br/>
                </c:forEach>
            </c:if>
            <c:if test="${sessionScope.orderhistory.size() == 1 &&  sessionScope.order_id == entry.key.getOrderId()}">
                ${history_empty}
            </c:if>
        </c:forEach>
    </c:if>
    <c:if test="${sessionScope.orderhistory.isEmpty() || sessionScope.orderhistory == null}">
        ${history_empty}
    </c:if>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
