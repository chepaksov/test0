<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 28.12.2019
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>PP01</title>
</head>
<body>
<a href="/add">Добавить юзера</a>
<ul>
    <c:forEach var="user" items="${users}">
        <li>Id: <c:out value="${user.id}"/>, Name: <c:out value="${user.name}"/>, Password: <c:out value="${user.password}"/>, Example: <c:out value="${user.example}"/> || <a href="/edit?param1=${user.name}">Изменить</a> <a href="/del?param1=${user.name}">Удалить</a> </li>
    </c:forEach>
</ul>
</body>
</html>