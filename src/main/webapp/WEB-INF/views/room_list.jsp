<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Available Rooms</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100">
<div class="container mx-auto p-4">
    <h2 class="text-2xl font-bold mb-6">Available Rooms</h2>
    <table class="w-full bg-white shadow-md rounded">
        <thead>
        <tr class="bg-gray-200">
            <th class="py-2 px-4">Room Number</th>
            <th class="py-2 px-4">Capacity</th>
            <th class="py-2 px-4">Class</th>
            <th class="py-2 px-4">Price/Night</th>
            <th class="py-2 px-4">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${rooms}" var="room">
            <tr>
                <td class="py-2 px-4">${room.number}</td>
                <td class="py-2 px-4">${room.capacity}</td>
                <td class="py-2 px-4">${room.roomClass}</td>
                <td class="py-2 px-4">$${room.pricePerNight}</td>
                <td class="py-2 px-4">
                    <a href="${pageContext.request.contextPath}/bookings?roomId=${room.id}"
                       class="text-blue-500 hover:underline">Book Now</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>