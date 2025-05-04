<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.*, org.lab.model.Booking" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Адмін-панель</title>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
<h2>Усі бронювання</h2>

<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
    if (bookings == null || bookings.isEmpty()) {
%>
<p>Бронювань немає.</p>
<%
} else {
%>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Гості</th>
        <th>Клас номера</th>
        <th>Дата заїзду</th>
        <th>Дата виїзду</th>
    </tr>
    <%
        for (Booking b : bookings) {
    %>
    <tr>
        <td><%= b.getGuests() %></td>
        <td><%= b.getRoomClass() %></td>
        <td><%= b.getCheckIn() %></td>
        <td><%= b.getCheckOut() %></td>
    </tr>
    <%
        }
    %>
</table>
<%
    }
%>

<br>
<a href="/">Назад до форми бронювання</a>
</body>
</html>
