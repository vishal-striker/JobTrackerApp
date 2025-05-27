<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Job</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-card {
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            width: 400px;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 12px;
            width: 100%;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        .back-link {
            margin-top: 15px;
            text-align: center;
        }

        .back-link a {
            color: #555;
            text-decoration: none;
            font-size: 14px;
        }

        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="form-card">
        <h2>Add New Job</h2>
        <form action="add-job" method="post">
            <label for="position">Position:</label>
            <input type="text" id="position" name="position" required>

            <label for="company">Company:</label>
            <input type="text" id="company" name="company" required>

            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="" disabled selected>-- Select Status --</option>
                <option value="Applied">Applied</option>
                <option value="Interview">Interview</option>
                <option value="Offer">Offer</option>
                <option value="Rejected">Rejected</option>
            </select>

            <label for="dateApplied">Date Applied:</label>
            <input type="date" id="dateApplied" name="dateApplied">

            <input type="submit" value="Add Job">
        </form>

        <div class="back-link">
            <p><a href="jobs">← Back to Job List</a></p>
        </div>
    </div>

</body>
</html>
