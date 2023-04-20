<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<style>
    .wrapper {
        background-color: whitesmoke;
        list-style-type: none;
        padding: 0;
        border-radius: 3px;
    }

    .form-row {
        display: flex;
        padding: .5em;
    }

    .form-row > label {
        padding: .5em 1em .5em 0;
    }

    .form-row > input {
        flex: 1;
    }

    .form-row > input, .form-row > button {
        padding: .5em;
    }

    .form-row > button {
        background: gray;
        color: white;
        border: 0;
    }

    a {
        color: white;
        text-decoration: none;
    }

    a:visited {
        color: white;
        text-decoration: none;
    }

    a:hover {
        background: gray;
        color: white;
        text-decoration: none;
    }

    a:active {
        color: white;
    }
</style>

<head>
    <title>Login</title>
</head>

<body>
<ul class="wrapper">
<%@ include file="header.jsp"%>

<form action="${pageContext.request.contextPath}/login" method="post">

        <li class="form-row">
            <label for="email"><fmt:message key ="page.login.email"/>:</label>
            <input type="text" name="email" id="email" required>
        </li>
        <li class="form-row">
            <label for="password"><fmt:message key ="page.login.password"/>:</label>
            <input type="password" name="password" id="password" required>
        </li>
        <li class="form-row">
            <button type="submit"><fmt:message key ="page.login.submit.button"/></button>
        </li>
        <li class="form-row">
            <button type="button">
                <a href="${pageContext.request.contextPath}/registration"><fmt:message key ="page.login.register.button"/>
                </a>
            </button>
        </li>
        <c:if test="${param.error != null}">
            <div style="color: red">
            <span>
                <fmt:message key ="page.login.error"/>
            </span>
            </div>
        </c:if>

</form>
</ul>
</body>
</html>