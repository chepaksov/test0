<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<%@ page contentType="text/html;charset=utf-8" %>


<table border="1" cellspacing="0" cellpadding="2">
    <tr>
        <td>ID</td>
        <td>Username</td>
        <td>Password</td>
        <td>Role</td>

    </tr>


    <tr>
        <td>${messages.id}</td>
        <td>${messages.username}</td>
        <td>${messages.password}</td>
        <td>${role}</td>

    </tr>


    <sec:authorize access="isAuthenticated()">
    <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>

</body>
</html>