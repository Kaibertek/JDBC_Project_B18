package com.cybertek.day1;

import java.sql.*;

public class IteratingPractice2 {
	public static void main(String[] args) throws SQLException {
		String connectionString = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
		String username = "hr";
		String password = "hr";
		Connection conn = DriverManager.getConnection(connectionString, username, password);
		Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = stmnt.executeQuery("Select * from countries where region_id = 1");

		rs.next();
		System.out.println(rs.getString("Country_id") + " " + "Country_name");
	}
}