<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Hotel Booking System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100 min-h-screen">
<div class="min-h-screen flex items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-xl w-full max-w-md">
        <h1 class="text-3xl font-bold mb-6 text-center text-gray-800">Login</h1>
        <% if (request.getAttribute("error") != null) { %>
        <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative mb-4" role="alert">
            <span class="block sm:inline"><%= request.getAttribute("error") %></span>
        </div>
        <% } %>
        <form action="/TestJSP/login" method="post" class="space-y-4">
            <div>
                <label for="login" class="block text-sm font-medium text-gray-700">Login</label>
                <input type="text" name="login" id="login" required class="mt-1 block w-full border-gray-300 rounded-md p-2">
            </div>
            <div>
                <label for="password" class="block text-sm font-medium text-gray-700">Password</label>
                <input type="password" name="password" id="password" required class="mt-1 block w-full border-gray-300 rounded-md p-2">
            </div>
            <button type="submit" class="w-full bg-blue-500 text-white py-3 px-4 rounded-lg">
                Login
            </button>
        </form>
    </div>
</div>
</body>
</html>