package com.cybertek.day1;

import java.sql.*;

public class IteratingResultSetBackwardPractice {
	public static void main(String[] args) throws SQLException {
		String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
		String username = "hr";
		String password = "hr";
		Connection conn = DriverManager.getConnection(connectionStr, username, password);
		// if we create the Statement in this way , this will generate a forward only resultset
		// meaning we can only move forward with next() and can not move backward with previous
		//Statement stmnt = conn.createStatement();
		// ResultSet.TYPE_SCROLL_INSENSITIVE will make the resultset created from this statement
		// be able to move forward and backward ,
		// ResultSet.CONCUR_READ_ONLY  will make resultset readonly and that's what we need
		Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		//ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = 1") ;
		ResultSet rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");

		//first move to the after last location
		//then keep moving to previous row as long as there's more row above.
		rs.afterLast();

		//System.out.println(rs.getString(1) + " " + rs.getString(2));
		while (rs.previous() == true) {
			System.out.println(rs.getString(1) + " " + rs.getString(2));
		}
		System.out.println("---------more moving-------------");
		//how to move to second rwo from here:
		rs.absolute(2);
		System.out.println("Currently I shold be at 2nd row " + rs.getRow());

		System.out.println(rs.getString(1) + " " + rs.getString(2));

		rs.first();
	}
}