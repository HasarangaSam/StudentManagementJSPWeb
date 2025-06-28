package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import util.DBUtil;

public class StudentDAO {

	// Method to insert a student into the database
    public void insertStudent(Student student) {
        String sql = "INSERT INTO students (name, email, department) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set values from student object into the SQL query
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getDepartment());

            stmt.executeUpdate(); // Executes the insert
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all students from the database
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Loop through result set and add each student to list
            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department")
                );
                studentList.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }
    
}
