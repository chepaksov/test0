<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Страница авторизации</title>
</head>
<body>
<form action="/login" method="POST">
<h2>Страница авторизации</h2>
<p><b>Логин:</b><br>
    <input type="text" name="name" size="30"></p>
<p><b>Пароль:</b><br>
    <input type="text" name="password" size="30"></p>
<p><input type="submit" value="ОK"/>
</form>
</body>
</html>