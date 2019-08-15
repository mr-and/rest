<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <title>Add</title>
</head>
<h1>Добавить документ</h1>
<body>

<form action="${var}" method="POST">
    <c:if test="${!empty doc}">
        <input type="hidden" name="id" value="${doc.id}">
    </c:if>
    <label for="data">Дата</label>
    <input type="text" name="data" id="data">
    <label for="number">Номер</label>
    <input type="text" name="number" id="number">
    <label for="sum">Сумма</label>
    <input type="text" name="sum" id="sum">

    <c:if test="${empty doc}">
        <input type="submit" value="Создать новый документ">
    </c:if>
</form>
</body>

<a href="/">На главную</a>
</html>
