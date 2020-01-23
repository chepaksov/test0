<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<%@ page contentType="text/html;charset=utf-8" %>

<h1><a href="/add">Create</a></h1>

<table border="1" cellspacing="0" cellpadding="2">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Series</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>

    <c:forEach var="msg" items="${messages}">
    <tr>
        <td>${msg.id}</td>
        <td>${msg.name}</td>
        <td>${msg.series}</td>
        <td><a href="/edit?name=${msg.name}&id=${msg.id}">Изменить</a></td>
        <td><a href="/del?name=${msg.name}&id=${msg.id}&series=${msg.series}">Удалить</a></td>
    </tr>

    </c:forEach>


</body>
</html>