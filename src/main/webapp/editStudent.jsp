<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Student" %>
<%
    Student student = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4 text-center">✏️ Update Student Details</h2>
    <div class="card p-4 shadow-sm">
        <form action="editStudent" method="post">
            <input type="hidden" name="id" value="<%= student.getId() %>" />

            <div class="mb-3">
                <label class="form-label">Full Name</label>
                <input type="text" name="name" class="form-control" value="<%= student.getName() %>" required />
            </div>

            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" value="<%= student.getEmail() %>" required />
            </div>

            <div class="mb-3">
                <label class="form-label">Department</label>
                <input type="text" name="department" class="form-control" value="<%= student.getDepartment() %>" required />
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Update Student</button>
            </div>
        </form>
        <div class="mt-3 text-center">
            <a href="viewStudents" class="btn btn-secondary btn-sm">← Back to Student List</a>
        </div>
    </div>
</div>

</body>
</html>