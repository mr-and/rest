<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Docs</title>
</head>
<body>
<h2>Docs list</h2>
<table>
    <tr>
        <th>id</th>
        <th>data</th>
        <th>number</th>
        <th>sum</th>
    </tr>
    <c:forEach var="doc" items="${docsList}">
    <tr>
        <td>${doc.id}</td>
        <td>${doc.data}</td>
        <td>${doc.number}</td>
        <td>${doc.sum}</td>
    </tr>
    </c:forEach>
</body>
</html>
