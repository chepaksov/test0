<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
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
<form action="/admin/edit" method="POST">
    name: <input type="text" name="name" value="${name}"/>
    password: <input type="password" name="password"/>
    role: <input type="text" name="role"/>
    <input type="submit" value="Ok">
</form>
</body>
</html>
