<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel - Hotel Booking System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <style>
        .nav-link {
            transition: color 0.2s ease-in-out;
        }
        .nav-link:hover {
            color: #a3bffa;
        }
    </style>
</head>
<body class="bg-gray-100 min-h-screen">
<nav class="bg-gray-800 p-4 shadow-lg">
    <div class="max-w-4xl mx-auto flex justify-between items-center">
        <a href="/TestJSP/rooms" class="text-white text-xl font-semibold nav-link">Rooms</a>
        <div class="space-x-4">
            <a href="/TestJSP/profile" class="text-white nav-link mr-4">Profile</a>
            <a href="/TestJSP/admin" class="text-white nav-link mr-4">Admin Panel</a>
            <a href="/TestJSP/logout" class="text-white nav-link">Logout</a>
        </div>
    </div>
</nav>
<div class="container mx-auto p-4">
    <h1 class="text-3xl font-bold mb-6 text-center text-gray-800">Admin Panel - Pending Booking Requests</h1>
    <c:if test="${empty pendingRequests}">
        <p class="text-center text-gray-600">No pending requests.</p>
    </c:if>
    <c:forEach var="request" items="${pendingRequests}">
        <div class="mb-4 p-4 bg-white rounded-lg shadow">
            <p>ID: ${request.id}</p>
            <p>User: ${request.userId}</p>
            <p>Capacity: ${request.capacity}</p>
            <p>Room Class: ${request.roomClass}</p>
            <p>Start Date: ${request.startDate}</p>
            <p>End Date: ${request.endDate}</p>
            <form action="/TestJSP/admin" method="post" class="mt-2">
                <input type="hidden" name="action" value="assign">
                <input type="hidden" name="bookingId" value="${request.id}">
                <label for="roomId-${request.id}" class="block text-sm font-medium text-gray-700">Assign Room</label>
                <select name="roomId" id="roomId-${request.id}" required class="mt-1 block w-full border-gray-300 rounded-md p-2">
                    <c:forEach var="room" items="${availableRooms}">
                        <option value="${room.id}">${room.name} (Capacity: ${room.capacity}, Class: ${room.roomClass})</option>
                    </c:forEach>
                </select>
                <button type="submit" class="mt-2 bg-blue-500 text-white py-2 px-4 rounded-lg">Assign</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>