package controller;

import dao.StudentDAO;
import model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 🟢 Handle GET requests like ?id=2
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the ID from URL
        int id = Integer.parseInt(request.getParameter("id"));

        // Get student details from DAO
        StudentDAO dao = new StudentDAO();
        Student student = dao.getStudentById(id); // you must have this method in DAO

        // Set student as attribute and forward to JSP
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editStudent.jsp");
        dispatcher.forward(request, response);
    }
    
 // Handles POST requests from editStudent.jsp
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get updated values from the form
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String department = request.getParameter("department");

            // Create a new Student object with updated data
            Student student = new Student(id, name, email, department);

            // Call DAO to update the student in the database
            StudentDAO dao = new StudentDAO();
            dao.updateStudent(student);

            // Redirect back to view all students
            response.sendRedirect("viewStudents");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "⚠️ Error updating student: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
