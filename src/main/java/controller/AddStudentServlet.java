package controller;

import dao.StudentDAO;
import model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form input values
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");

        // Create Student object using the data
        Student student = new Student(name, email, department);

        // Insert into DB using DAO
        StudentDAO dao = new StudentDAO();
        dao.insertStudent(student);
        

        // Redirect to view page after insertion
        response.sendRedirect("viewStudents");
    }
}
