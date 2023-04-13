<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</style>

<head>
    <title>Title</title>
</head>

<body>
<h3>Record to DB</h3>
<form action="/registration" method="post">
    <ul class="wrapper">

        <li class="form-row">
            <label for="nameId">Name:</label>
            <input type="text" name="name" id="nameId">
        </li>

        <li class="form-row">
            <label for="birthdayId">Birthday:</label>
            <input type="date" name="birthday" id="birthdayId">
        </li>

        <li class="form-row">
            <label for="emailId">Email:</label>
            <input type="text" name="email" id="emailId">
        </li>

        <li class="form-row">
            <label for="passwordId">Password:</label>
            <input type="password" name="password" id="passwordId">
        </li>

        <select name="role" id="roleId">
            <c:forEach var="role" items="${requestScope.roles}">
                <option value=${role}>${role}</option>
            </c:forEach>
        </select>

        <c:forEach var="gender" items="${requestScope.genders}">
            <input type="radio" name="gender" value="${gender}"> ${gender}
        </c:forEach>

        <li class="form-row">
            <button type="submit">SEND</button>
        </li>

        <c:if test="${not empty requestScope.errors}">
            <div style="color: red">
                <c:forEach var="error" items="${requestScope.errors}">
                    <span>${error.message}</span><br>
                </c:forEach>
            </div>
        </c:if>
    </ul>
</form>
</body>
</html>