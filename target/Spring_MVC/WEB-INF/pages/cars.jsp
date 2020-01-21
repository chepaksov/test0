<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a href="${pageContext.request.contextPath}?lang=en">Login (English)</a>
    <c:out value="${cars}"/>
</head>
<body>
<forEach>


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
