<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вхід адміністратора</title>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
<h2>Форма входу адміністратора</h2>

<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<p style="color: red;"><%= error %></p>
<%
    }
%>

<form method="post" action="/login">
    <label>Логін:
        <input type="text" name="login" required>
    </label><br><br>

    <label>Пароль:
        <input type="password" name="password" required>
    </label><br><br>

    <button type="submit">Увійти</button>
</form>

<br>
<a href="/">Назад до бронювання</a>
</body>
</html>
