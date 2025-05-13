<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hotel Booking System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100">
<div class="min-h-screen flex items-center justify-center">
    <div class="bg-white p-8 rounded shadow-md w-full max-w-md text-center">
        <h1 class="text-3xl font-bold mb-6">Welcome to Hotel Booking System</h1>
        <p class="text-gray-700 mb-4">Please log in to access your account and book rooms.</p>
        <a href="${pageContext.request.contextPath}/login"
           class="inline-block bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600">
            Log In
        </a>
    </div>
</div>
</body>
</html>