<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@ include file="header.jsp" %>
    <title>SignUp</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <fmt:setLocale value="${sessionScope.localization}"/>
    <fmt:setBundle basename="locale/localization"/>
    <fmt:message key="local.signUp" var="signUp"/>
    <fmt:message key="local.name" var="firstName"/>
    <fmt:message key="local.lastName" var="lastName"/>
    <fmt:message key="local.password" var="password"/>
    <fmt:message key="local.email" var="email"/>
    <fmt:message key="local.birthDate" var="birthDate"/>
    <fmt:message key="local.gender" var="gender"/>
    <fmt:message key="local.genderM" var="M"/>
    <fmt:message key="local.genderF" var="F"/>
    <fmt:message key="local.submit" var="create"/>
    <fmt:message key="local.toHome" var="homePage"/>
</head>
<body>
<div class="container" id="wrap">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form id="register" action="controller" method="POST" accept-charset="utf-8" class="form"
                  role="form">
                <input type="hidden" name="command" value="register"/>
                <legend>${signUp}</legend>
                <div class="row">
                    <div class="col-xs-6 col-md-6 mb-1" id="id_div">
                        <input type="text" name="firstname" pattern="^[a-zA-Z_\-]+$"
                               title="Please enter only alphabetic characters." value=""
                               class="form-control input-lg"
                               placeholder="${firstName}" required/>
                    </div>
                    <div class="col-xs-6 col-md-6 mb-1" id="surname_div">
                        <input type="text" name="lastname" pattern="^[a-zA-Z_\-]+$"
                               title="Please enter only alphabetic characters."
                               value="" class="form-control input-lg"
                               placeholder="${lastName}" required/>
                    </div>
                </div>
                <div id="email_div">
                    <input id="email" type="text" name="email" value=""
                           pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3})|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$"
                           title="Please enter valid email form."
                           class="form-control input-lg mb-1" placeholder="${email}"
                           required/>
                    <div id="email_error"></div>
                </div>
                <input type="password" name="password" value="" class="form-control input-lg mb-1"
                       placeholder="${password}" required/>
                <label>${birthDate}</label>
                <div class="row">
                    <div class="col-xs-4 col-md-4 mb-1">
                        <select name="month" class="form-control input-lg">
                            <option value="01">Jan</option>
                            <option value="02">Feb</option>
                            <option value="03">Mar</option>
                            <option value="04">Apr</option>
                            <option value="05">May</option>
                            <option value="06">Jun</option>
                            <option value="07">Jul</option>
                            <option value="08">Aug</option>
                            <option value="09">Sep</option>
                            <option value="10">Oct</option>
                            <option value="11">Nov</option>
                            <option value="12">Dec</option>
                        </select></div>
                    <div class="col-xs-4 col-md-4 mb-1">
                        <select name="day" class="form-control input-lg">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                        </select></div>
                    <div class="col-xs-4 col-md-4 mb-1">
                        <select name="year" class="form-control input-lg">
                            <option value="1935">1935</option>
                            <option value="1936">1936</option>
                            <option value="1937">1937</option>
                            <option value="1938">1938</option>
                            <option value="1939">1939</option>
                            <option value="1940">1940</option>
                            <option value="1941">1941</option>
                            <option value="1942">1942</option>
                            <option value="1943">1943</option>
                            <option value="1944">1944</option>
                            <option value="1945">1945</option>
                            <option value="1946">1946</option>
                            <option value="1947">1947</option>
                            <option value="1948">1948</option>
                            <option value="1949">1949</option>
                            <option value="1950">1950</option>
                            <option value="1951">1951</option>
                            <option value="1952">1952</option>
                            <option value="1953">1953</option>
                            <option value="1954">1954</option>
                            <option value="1955">1955</option>
                            <option value="1956">1956</option>
                            <option value="1957">1957</option>
                            <option value="1958">1958</option>
                            <option value="1959">1959</option>
                            <option value="1960">1960</option>
                            <option value="1961">1961</option>
                            <option value="1962">1962</option>
                            <option value="1963">1963</option>
                            <option value="1964">1964</option>
                            <option value="1965">1965</option>
                            <option value="1966">1966</option>
                            <option value="1967">1967</option>
                            <option value="1968">1968</option>
                            <option value="1969">1969</option>
                            <option value="1970">1970</option>
                            <option value="1971">1971</option>
                            <option value="1972">1972</option>
                            <option value="1973">1973</option>
                            <option value="1974">1974</option>
                            <option value="1975">1975</option>
                            <option value="1976">1976</option>
                            <option value="1977">1977</option>
                            <option value="1978">1978</option>
                            <option value="1979">1979</option>
                            <option value="1980">1980</option>
                            <option value="1981">1981</option>
                            <option value="1982">1982</option>
                            <option value="1983">1983</option>
                            <option value="1984">1984</option>
                            <option value="1985">1985</option>
                            <option value="1986">1986</option>
                            <option value="1987">1987</option>
                            <option value="1988">1988</option>
                            <option value="1989">1989</option>
                            <option value="1990">1990</option>
                            <option value="1991">1991</option>
                            <option value="1992">1992</option>
                            <option value="1993">1993</option>
                            <option value="1994">1994</option>
                            <option value="1995">1995</option>
                            <option value="1996">1996</option>
                            <option value="1997">1997</option>
                            <option value="1998">1998</option>
                            <option value="1999">1999</option>
                            <option value="2000">2000</option>
                            <option value="2001">2001</option>
                            <option value="2002">2002</option>
                            <option value="2003">2003</option>
                            <option value="2004">2004</option>
                            <option value="2005">2005</option>
                            <option value="2006">2006</option>
                            <option value="2007">2007</option>
                            <option value="2008">2008</option>
                            <option value="2009">2009</option>
                            <option value="2010">2010</option>
                            <option value="2011">2011</option>
                            <option value="2012">2012</option>
                            <option value="2013">2013</option>
                        </select></div>
                </div>
                <label>${gender} : </label> <label class="radio-inline">
                <input type="radio" name="gender" value="M" id=male required/> ${M}
            </label>
                <label class="radio-inline">
                    <input type="radio" name="gender" value="F" id=female required/> ${F}
                </label>
                <br/>
                <button id="submitbutton" class="submit btn btn-lg btn-primary btn-block signup-btn" type="submit">
                    ${create}
                </button>
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
<script src="resources/js/register.js"></script>
</body>
</html>

