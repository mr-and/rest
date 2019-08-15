<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete</title>
</head>
<h1>Удалить документ по номеру</h1>
<body>


<form action="${var}" method="POST">

    <input type="text" name="number" id="number">

    <c:if test="${empty del.number}">
        <input type="submit" value="Введите номер">
    </c:if>

</form>
</body>

<a href="/">На главную</a>
</html>