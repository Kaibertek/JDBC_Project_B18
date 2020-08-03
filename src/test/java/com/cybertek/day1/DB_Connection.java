package com.cybertek.day1;

import java.sql.*;
import java.sql.DriverManager;

public class DB_Connection {
	public static void main(String[] args) throws SQLException {
		//Connection -> Statement -> ResultSet
		//Driver manager is used to get the connection
		String connectionString = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
		String username = "hr";
		String password = "hr";

		//Creating connection object using DriverManager's static method Connection.
		Connection conn = DriverManager.getConnection
				(connectionString, username, password);

		Statement stmnt = conn.createStatement();
		ResultSet rs = stmnt.executeQuery("Select * from regions");
		//statement object, we are creating a statement
//to be able to do this, create a STATEMENT object
// ---> what can we do with this?
		//  ---> we can write our query with this object
		//----> then we can store out results into our object?

		//ResultSet comes with a cursor used to navigate between rows.
		//initially the cursor is at before first location (first before the first row)
		// in order to come to the first row we need to move the cursor
		//next() method is used to move the cursor and return the result as boolean.
		rs.next();

		System.out.println("First column value using index: " + rs.getString(1));
		System.out.println("First column value using column_name: " + rs.getString("Region_ID"));

		System.out.println("Second column value using index: " + rs.getString(2));
		System.out.println("Second column value using column_name: " + rs.getString("Region_Name"));

		//move to next row and get second row data as a task
		rs.next();
		System.out.println("First column value using index: " + rs.getString(1));
		System.out.println("First column value using column_name: " + rs.getString("Region_ID"));

		System.out.println("Second column value using index: " + rs.getString(2));
		System.out.println("Second column value using column_name: " + rs.getString("Region_Name"));



	}
}
