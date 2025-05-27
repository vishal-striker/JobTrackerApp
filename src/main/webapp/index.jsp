<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Job Tracker Home</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(120deg, #3498db, #8e44ad);
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }

        .home-container {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 40px 60px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0,0,0,0.2);
            text-align: center;
            color: #2c3e50;
        }

        h1 {
            font-size: 32px;
            margin-bottom: 20px;
        }

        a.button-link {
            display: inline-block;
            background-color: #3498db;
            color: white;
            padding: 12px 24px;
            border-radius: 8px;
            text-decoration: none;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        a.button-link:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

<div class="home-container">
    <h1>🚀 Welcome to Job Tracker</h1>
    <a class="button-link" href="jobs">View Job Applications</a>
</div>

</body>
</html>
