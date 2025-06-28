package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import util.DBUtil;

@WebServlet("/test")
public class TestConnectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = DBUtil.getConnection();
        
        if (conn != null) {
            out.println("<h2 style='color:green;'>✅ Database Connection Successful!</h2>");
        } else {
            out.println("<h2 style='color:red;'>❌ Database Connection Failed!</h2>");
        }
    }
}
