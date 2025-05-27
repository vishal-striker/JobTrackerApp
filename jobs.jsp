<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Job Applications</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f4;
            padding: 30px;
            color: #333;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
        }

        table {
            width: 90%;
            margin: 0 auto 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #eaf2f8;
        }

        .add-link {
            text-align: center;
            margin-bottom: 30px;
        }

        .add-link a {
            text-decoration: none;
            background-color: #2ecc71;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .add-link a:hover {
            background-color: #27ae60;
        }
    </style>
</head>
<body>
    <h2>Job Applications</h2>

    <!-- Add Job Link -->
    <div class="add-link">
        <p><a href="add-job.jsp">➕ Add New Job Application</a></p>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Position</th>
            <th>Company</th>
            <th>Status</th>
            <th>Date Applied</th>
        </tr>

        <c:forEach var="job" items="${jobs}">
            <tr>
                <td>${job.id}</td>
                <td>${job.position}</td>
                <td>${job.company}</td>
                <td>${job.status}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty job.dateApplied}">
                            <fmt:formatDate value="${job.dateApplied}" pattern="yyyy-MM-dd" />
                        </c:when>
                        <c:otherwise>N/A</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>

        <c:if test="${empty jobs}">
            <tr>
                <td colspan="5">No job applications found (debug: list is empty)</td>
            </tr>
        </c:if>
    </table>
</body>
</html>
