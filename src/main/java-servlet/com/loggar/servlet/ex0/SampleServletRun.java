package com.loggar.servlet.ex0;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleServletRun extends HttpServlet {
	private static final long serialVersionUID = 8169140096148446088L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "error";

		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		String sql = "SELECT ID, name from student";

		try (Connection con = DriverManager
				.getConnection("jdbc:jtds:sqlserver://jackjang.database.windows.net//thirdDB", "jack", "$a5muF8H");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				System.out.println(rs.getString("ID") + ", " + rs.getString("name"));
				if ("2".equals(rs.getString("ID")))
					result = rs.getString("name");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(result);
		pw.close();
	}
}
