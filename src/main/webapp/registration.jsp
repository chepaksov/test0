<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Страница регистрации</title>
</head>
<body>
<form action="/add" method="POST">
    <h2>Страница регистрации</h2>
    Логин:
    <input type="text" name="name" size="30">
    Пароль:
    <input type="text" name="password" size="30">
    Роль:
    <input type="text" name="role" size="30">
    <input type="submit" value="ОK"/>
</form>
</body>
</html>