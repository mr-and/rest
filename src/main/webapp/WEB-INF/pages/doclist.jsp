<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Docs</title>
</head>
<body>
<h1>Список документов</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Дата</th>
        <th>Номер</th>
        <th>Сумма</th>
    </tr>
    <c:forEach var="doc" items="${docsList}">
    <tr>
        <td>${doc.id}</td>
        <td>${doc.data}</td>
        <td>${doc.number}</td>
        <td>${doc.sum}</td>
    </tr>
    </c:forEach>


</table>
</body>

<a href="/">На главную</a>
</html>
