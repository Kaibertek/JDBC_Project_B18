package com.cybertek.day1;

import java.sql.*;

public class IteratingResultSet {
	public static void main(String[] args) throws SQLException {
		String connectionString = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
		String username = "hr";
		String password = "hr";
		Connection conn = DriverManager.getConnection(connectionString, username, password);
		Statement stmnt = conn.createStatement();
		ResultSet rs = stmnt.executeQuery("Select * from regions");

		//as long as rs.next() is true, I know I have next row to print the data.
		//we will keep looping as long as rs.next() is true.

		while(rs.next()==true){
			System.out.println(rs.getString("Region_ID") + " " + rs.getString("Region_name"));
		}

//		rs.next();
//		System.out.println(rs.getString("Region_ID") + " " + rs.getString("Region_name"));
//		rs.next();
//		System.out.println(rs.getString(1) + " " + rs.getString(2));
//
//		rs.next();
//		System.out.println(rs.getString("Region_ID") + " " + rs.getString("Region_name"));
//		rs.next();
//		System.out.println(rs.getString(1) + " " + rs.getString(2));
//
//		System.out.println(rs.next());
	}
}
