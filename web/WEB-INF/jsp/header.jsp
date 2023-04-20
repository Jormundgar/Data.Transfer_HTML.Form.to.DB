<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    table {
        border: hidden;
    }

    td, th {
        border: hidden;
    }

</style>
<%@ include file="locale.jsp"%>
<ul class="wrapper">
    <div>
        <table>
            <tr>
                    <th>
                        <form action="${pageContext.request.contextPath}/locale" method="post">
                        <li class="form-row">
                            <button type="submit" name="lang" value="en_EN"><fmt:message key ="header.en"/></button>
                        </li>
                        </form>
                    </th>
                    <th>
                        <form action="${pageContext.request.contextPath}/locale" method="post">
                        <li class="form-row">
                            <button type="submit" name="lang" value="ru_RU"><fmt:message key ="header.ru"/></button>
                        </li>
                        </form>
                    </th>
                    <th>
                        <form action="${pageContext.request.contextPath}/locale" method="post">
                        <li class="form-row">
                            <button type="submit" name="lang" value="he_IL"><fmt:message key ="header.he"/></button>
                        </li>
                        </form>
                    </th>
                <th>
                    <c:if test="${not empty sessionScope.user}">
                        <form action="${pageContext.request.contextPath}/logout" method="post">
                            <li class="form-row">
                                <button type="submit"><fmt:message key ="header.logout"/></button>
                            </li>
                        </form>
                    </c:if>
                </th>
            </tr>
        </table>
    </div>
</ul>
