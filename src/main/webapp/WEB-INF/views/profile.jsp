<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Profile - Hotel Booking System</title>
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
<div class="min-h-screen flex items-center justify-center">
  <div class="bg-white p-8 rounded-lg shadow-xl w-full max-w-4xl">
    <h1 class="text-3xl font-bold mb-6 text-center text-gray-800">My Bookings</h1>
    <div class="space-y-6">
      <c:if test="${empty bookings}">
        <p class="text-center text-gray-600">No bookings found.</p>
      </c:if>
      <c:forEach var="booking" items="${bookings}">
        <div class="border p-6 rounded-lg bg-white shadow-md">
          <div class="grid grid-cols-7 gap-4">
            <div class="text-center">
              <p class="font-semibold text-gray-700">ID</p>
              <p class="mt-1 text-gray-900">${booking.id}</p>
            </div>
            <div class="text-center">
              <p class="font-semibold text-gray-700">Room</p>
              <p class="mt-1 text-gray-900">${booking.roomId != null ? booking.roomId : 'Not assigned'}</p>
            </div>
            <div class="text-center">
              <p class="font-semibold text-gray-700">Start Date</p>
              <p class="mt-1 text-gray-900">${booking.startDate}</p>
            </div>
            <div class="text-center">
              <p class="font-semibold text-gray-700">End Date</p>
              <p class="mt-1 text-gray-900">${booking.endDate}</p>
            </div>
            <div class="text-center">
              <p class="font-semibold text-gray-700">Capacity</p>
              <p class="mt-1 text-gray-900">${booking.capacity} persons</p>
            </div>
            <div class="text-center">
              <p class="font-semibold text-gray-700">Class</p>
              <p class="mt-1 text-gray-900">${booking.roomClass}</p>
            </div>
            <div class="text-center">
              <p class="font-semibold text-gray-700">Status</p>
              <p class="mt-1 text-gray-900">${booking.status}</p>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</div>
</body>
</html>