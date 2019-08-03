<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <a href="/adddoc">Adddoc</a>
     <t> </t>
     <a href="/doclist">Doclist</a>
     <t> </t>
     <a href="/deldoc">Deldoc</a>
     <t> </t>
     <a href="/login">Login</a>

     <a href="<c:url value="/logout" />">Logout</a>
</body>
</html>
