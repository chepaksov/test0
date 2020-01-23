<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Create</title>
</head>
<body>
<form action="/add" method="POST">
    <h2>Create</h2>
    Логин:
    <input type="text" name="name" size="30">
    Series:
    <input type="text" name="series" size="30">
    <input type="submit" value="ОK"/>
</form>


<%--@elvariable id="mans" type="antlr"--%>
<form:form method="post" modelAttribute="mans">
<table>
    <tr>


    </tr>
    <td colspan="3"><input type="submit" value="Submit" /></td>
    </tr>
</table>
</form:form>



</body>
</html>