<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Bookings</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100">
<div class="container mx-auto p-4">
    <h2 class="text-2xl font-bold mb-6">My Bookings</h2>
    <table class="w-full bg-white shadow-md rounded">
        <thead>
        <tr class="bg-gray-200">
            <th class="py-2 px-4">Booking ID</th>
            <th class="py-2 px-4">Room ID</th>
            <th class="py-2 px-4">Check-in</th>
            <th class="py-2 px-4">Check-out</th>
            <th class="py-2 px-4">Total Price</th>
            <th class="py-2 px-4">Status</th>
            <th class="py-2 px-4">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookings}" var="booking">
            <tr>
                <td class="py-2 px-4">${booking.id}</td>
                <td class="py-2 px-4">${booking.roomId}</td>
                <td class="py-2 px-4">${booking.checkInDate}</td>
                <td class="py-2 px-4">${booking.checkOutDate}</td>
                <td class="py-2 px-4">$${booking.totalPrice}</td>
                <td class="py-2 px-4">${booking.status}</td>
                <td class="py-2 px-4">
                    <a href="${pageContext.request.contextPath}/bookings/${booking.id}"
                       class="text-blue-500 hover:underline">View Invoice</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>