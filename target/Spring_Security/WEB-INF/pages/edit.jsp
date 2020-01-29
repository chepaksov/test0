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
<form action="/admin/edit" method="POST">
    Id: <input type="text" name="id" value="${user.id}"/>
    Login: <input type="text" name="username" value="${user.username}"/>
    Password: <input type="text" name="password" value="${user.password}"/>
    <input type="submit" value="Ok">
</form>
</body>
</html>
