<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Документооборот</title>
</head>
     <a href="/adddoc">Добавить пользователя</a>
     <br>
     <a href="/doclist">Список документов</a>
     <br>
     <a href="/deldoc">Удалить документ</a>
     <br>
     <br>
     <a href="/login">Авторизация</a>
     <br>
     <a href="<c:url value="/logout" />">Выйти</a>
</body>
</html>
