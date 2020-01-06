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
        <li><c:out value="${user}"/> <a href="/edit?param1=${user}">Изменить</a> <a href="/del?param1=${user}">Удалить</a> </li>
    </c:forEach>
</ul>
</body>
</html>
