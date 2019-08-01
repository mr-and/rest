<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete</title>
</head>
<h1>Delete doc</h1>
<body>



<form action="${var}" method="POST">

    <input type="text" name="number" id="number">

    <c:if test="${empty del.number}">
        <input type="submit" value="Delete doc">
    </c:if>

</form>


</body>
</html>