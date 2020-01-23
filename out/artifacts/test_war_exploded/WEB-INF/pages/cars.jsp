<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 20.01.2020
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<forEach>
    <a href="${pageContext.request.contextPath}?lang=en">English</a>
    <br><a href="${pageContext.request.contextPath}?lang=ru">Russian</a>

    <table border="1" cellspacing="0" cellpadding="2">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Series</td>
        </tr>

        <c:forEach var="msg" items="${messages}">
        <tr>
            <td>${msg.id}</td>
            <td>${msg.name}</td>
            <td>${msg.series}</td>
        </tr>

        </c:forEach>

</body>
</html>
