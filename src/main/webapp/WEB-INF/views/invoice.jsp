<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Invoice</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100">
<div class="container mx-auto p-4">
    <h2 class="text-2xl font-bold mb-6">Invoice</h2>
    <c:if test="${not empty booking}">
        <div class="bg-white p-6 rounded shadow-md">
            <p><strong>Booking ID:</strong> ${booking.id}</p>
            <p><strong>Room ID:</strong> ${booking.roomId}</p>
            <p><strong>Check-in Date:</strong> ${booking.checkInDate}</p>
            <p><strong>Check-out Date:</strong> ${booking.checkOutDate}</p>
            <p><strong>Total Price:</strong> $${booking.totalPrice}</p>
            <p><strong>Status:</strong> ${booking.status}</p>
        </div>
    </c:if>
    <c:if test="${empty booking}">
        <p class="text-red-500">Booking not found</p>
    </c:if>
</div>
</body>
</html>