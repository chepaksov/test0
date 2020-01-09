<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 06.01.2020
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PP05</title>
</head>
<body>
<a href="/user">Страница юзера</a>
<ul>
    <c:forEach var="user" items="${users}">
        <li>Id: <c:out value="${user.id}"/>, Name: <c:out value="${user.name}"/>, Password: <c:out value="${user.password}"/>, Role: <c:out value="${user.role}"/> || <a href="/admin/edit?param1=${user.name}">Изменить</a> <a href="/admin/del?param1=${user.name}">Удалить</a> </li>
    </c:forEach>
</ul>
</body>
</html>
