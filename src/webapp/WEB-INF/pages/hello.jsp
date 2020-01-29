<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<%@ page contentType="text/html;charset=utf-8" %>

<h1><a href="/admin/add">Create</a></h1>

<table border="1" cellspacing="0" cellpadding="2">
    <tr>
        <td>ID</td>
        <td>Login</td>
        <td>Password</td>
        <td>Role</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>

    <c:forEach var="msg" items="${messages}">
    <tr>
        <td>${msg.id}</td>
        <td>${msg.username}</td>
        <td>${msg.password}</td>
        <td><c:forEach var="roleee" items="${msg.role}">
            ${roleee.role}
        </c:forEach>
        </td>
        <td><a href="/admin/edit?username=${msg.username}&id=${msg.id}">Изменить</a></td>
        <td><a href="admin/del?username=${msg.username}&id=${msg.id}&password=${msg.password}">Удалить</a></td>
    </tr>

    </c:forEach>


    <sec:authorize access="isAuthenticated()">
    <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>


</body>

</html>