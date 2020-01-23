
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 30.12.2019
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit pp05</title>
</head>
<body>
<form action="/edit" method="POST">
    Name: <input type="text" name="name" value="${name}"/>
    Series: <input type="text" name="series"/>
    <input type="submit" value="Ok">
</form>
</body>
</html>
