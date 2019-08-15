<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AccessDenied page</title>
</head>
<body>
Уважаемый <strong>${user}</strong>, у Вас нет доступа к данной странице
<a href="<c:url value="/logout" />">Выйти</a>
<br>
<a href="/">На главную</a>
</body>
</html>