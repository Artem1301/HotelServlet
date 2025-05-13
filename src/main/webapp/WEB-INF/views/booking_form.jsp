<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Booking</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100">
<div class="container mx-auto p-4">
    <h2 class="text-2xl font-bold mb-6">Create Booking</h2>
    <c:if test="${not empty error}">
        <p class="text-red-500 mb-4">${error}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/bookings" method="post">
        <div class="mb-4">
            <label class="block text-gray-700">Room Capacity</label>
            <input type="number" name="capacity" class="w-full px-3 py-2 border rounded" required>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700">Room Class</label>
            <select name="roomClass" class="w-full px-3 py-2 border rounded" required>
                <option value="STANDARD">Standard</option>
                <option value="DELUXE">Deluxe</option>
            </select>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700">Check-in Date</label>
            <input type="date" name="checkIn" class="w-full px-3 py-2 border rounded" required>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700">Check-out Date</label>
            <input type="date" name="checkOut" class="w-full px-3 py-2 border rounded" required>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700">Select Room</label>
            <select name="roomId" class="w-full px-3 py-2 border rounded" required>
                <c:forEach items="${rooms}" var="room">
                    <option value="${room.id}">${room.number} - ${room.roomClass} ($${room.pricePerNight}/night)</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600">Create Booking</button>
    </form>
</div>
</body>
</html>