<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.*, javax.servlet.http.*, javax.servlet.jsp.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Форма бронювання</title>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
<h2>Форма бронювання</h2>
<form method="post" action="/book">
    <label>Кількість гостей:
        <input type="number" name="guests" required>
    </label><br><br>

    <label>Клас номера:
        <select name="room-class">
            <option value="economy">Економ</option>
            <option value="standard">Стандарт</option>
            <option value="luxury">Люкс</option>
        </select>
    </label><br><br>

    <label>Дата заїзду:
        <input type="date" name="check-in" required>
    </label><br><br>

    <label>Дата виїзду:
        <input type="date" name="check-out" required>
    </label><br><br>

    <button type="submit">Забронювати</button>
</form>

<br>
<a href="/login">Увійти як адміністратор</a>
</body>
</html>
