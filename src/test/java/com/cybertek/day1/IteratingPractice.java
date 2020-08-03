package com.cybertek.day1;

import java.sql.*;

public class IteratingPractice {
	public static void main(String[] args) throws SQLException {
		String connectionString = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
		String username = "hr";
		String password = "hr";
		Connection conn = DriverManager.getConnection(connectionString, username, password);
		Statement stmnt = conn.createStatement();
		ResultSet rs = stmnt.executeQuery("Select * from countries where region_id = 1");

		while(rs.next()==true){
			System.out.println(
					rs.getString(1) + " " +
					rs.getString(2)+ " " +
					rs.getString(3));
		}

		rs.previous();

	}
}
