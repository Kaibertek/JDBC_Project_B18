package com.cybertek.day2;
import java.sql.*;

public class DB_Utility {
	/*
	a method to create connection with valid URL,
	and username and password.
*/
	//adding static field so we can access in all static methods:
	private static Connection conn;
	private static ResultSet rs;
	public static void createConnection() {
		String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
		String username = "hr";
		String password = "hr";
		try {
			Connection conn = DriverManager.getConnection(connectionStr, username, password);
			System.out.println("Connection success.");
		} catch (SQLException throwables) {
			System.out.println("Connection has failed!");
			throwables.printStackTrace();
		}
	}

	/*a method to get the resultSet object,
		with valid connection by executing query.
		*/
	public static ResultSet runQuery(String Query) {
		try {
			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmnt.executeQuery(Query);
		}catch (SQLException throwables){
			throwables.printStackTrace();
		}
		return rs;
	}
}


