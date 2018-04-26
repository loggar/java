package com.loggar.servlet.ex0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTest {
	public static void main(String [] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			System.out.println("jdbc driver loading");
			con = DriverManager.getConnection("jdbc:jtds:sqlserver://jackjang.database.windows.net//thirdDB", "jack", "$a5muF8H");
			stmt = con.createStatement();
			String sql = "SELECT ID, name from student";
			rs = stmt.executeQuery(sql);
			System.out.println("execute sql");
			while(rs.next()) {
				System.out.println(rs.getString("ID") + ", " + rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) try { stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(con != null) try { con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
