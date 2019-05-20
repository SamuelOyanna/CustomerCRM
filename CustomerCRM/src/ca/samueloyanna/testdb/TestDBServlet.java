package ca.samueloyanna.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "hbstudent";
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";

			String password = "hbstudent";
			String driver = "com.mysql.jdbc.Driver";
			
			try {
				PrintWriter writer = response.getWriter();
				writer.println("Connecting to database " + url);
				
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, user, password);
				
				writer.println("Success");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}

}
