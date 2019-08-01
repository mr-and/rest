<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <title>Add</title>
</head>
<body>

<form action="${var}" method="POST">
    <c:if test="${!empty doc}">
        <input type="hidden" name="id" value="${doc.id}">
    </c:if>
    <label for="data">Data</label>
    <input type="text" name="data" id="data">
    <label for="number">Number</label>
    <input type="text" name="number" id="number">
    <label for="sum">Sum</label>
    <input type="text" name="sum" id="sum">

    <c:if test="${empty doc}">
        <input type="submit" value="Add new doc">
    </c:if>

</form>
</body>
</html>
