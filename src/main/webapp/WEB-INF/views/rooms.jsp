<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Rooms - Hotel Booking System</title>
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
    <h1 class="text-3xl font-bold mb-6 text-center text-gray-800">Available Rooms</h1>
    <% if (request.getAttribute("error") != null) { %>
    <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative mb-4" role="alert">
        <span class="block sm:inline"><%= request.getAttribute("error") %></span>
    </div>
    <% } %>
    <form action="/TestJSP/rooms" method="post" class="space-y-4">
        <input type="hidden" name="action" value="createRequest">
        <div class="grid grid-cols-2 gap-4">
            <div>
                <label for="firstName" class="block text-sm font-medium text-gray-700">First Name</label>
                <input type="text" name="firstName" id="firstName" required class="mt-1 block w-full border-gray-300 rounded-md p-2">
            </div>
            <div>
                <label for="middleName" class="block text-sm font-medium text-gray-700">Middle Name</label>
                <input type="text" name="middleName" id="middleName" required class="mt-1 block w-full border-gray-300 rounded-md p-2">
            </div>
            <div>
                <label for="phone" class="block text-sm font-medium text-gray-700">Phone</label>
                <input type="text" name="phone" id="phone" required class="mt-1 block w-full border-gray-300 rounded-md p-2">
            </div>
            <div>
                <label for="capacity" class="block text-sm font-medium text-gray-700">Capacity</label>
                <input type="number" name="capacity" id="capacity" required class="mt-1 block w-full border-gray-300 rounded-md p-2">
            </div>
            <div>
                <label for="roomClass" class="block text-sm font-medium text-gray-700">Room Class</label>
                <select name="roomClass" id="roomClass" required class="mt-1 block w-full border-gray-300 rounded-md p-2">
                    <option value="STANDARD">Standard</option>
                    <option value="DELUXE">Deluxe</option>
                    <option value="SUITE">Suite</option>
                </select>
            </div>
            <div>
                <label for="startDate" class="block text-sm font-medium text-gray-700">Start Date</label>
                <input type="date" name="startDate" id="startDate" required class="mt-1 block w-full border-gray-300 rounded-md p-2">
            </div>
            <div>
                <label for="endDate" class="block text-sm font-medium text-gray-700">End Date</label>
                <input type="date" name="endDate" id="endDate" required class="mt-1 block w-full border-gray-300 rounded-md p-2">
            </div>
        </div>
        <button type="submit" class="w-full bg-blue-500 text-white py-3 px-4 rounded-lg">
            Create Booking Request
        </button>
    </form>
</div>
</body>
</html>