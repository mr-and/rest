<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HelloWorld Admin page</title>
</head>
<body>
Уважаемый <strong>${user}</strong>, добро пожаловть на страницу администратора
<a href="<c:url value="/logout" />">Logout</a>

<a href="/">На главную</a>
</body>
</html>