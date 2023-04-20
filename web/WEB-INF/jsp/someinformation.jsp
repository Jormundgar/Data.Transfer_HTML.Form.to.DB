<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

</style>
<%@ include file="header.jsp"%>
<head>
  <title><fmt:message key="page.info.title"/></title>
</head>

<body>

  <h2><fmt:message key="page.info.message"/></h2>
</body>
</html>
