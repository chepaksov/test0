<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<%@ page contentType="text/html;charset=utf-8" %>
<input type="submit" value="Добавить"
       onclick="window.location='registration.jsp';" />




<c:forEach var="msq" items="${messages}">
    <h1>${msq}</h1>
</c:forEach>
чспрва
<c:forEach var="user" items="${users}">
    <li>Id: <c:out value="${user.id}"/>, Name: <c:out value="${user.name}"/>, Password: <c:out value="${user.password}"/>, Role: <c:out value="${user.role}"/> || <a href="/admin/edit?param1=${user.name}">Изменить</a> <a href="/admin/del?param1=${user.name}">Удалить</a> </li>
</c:forEach>

</body>
</html>