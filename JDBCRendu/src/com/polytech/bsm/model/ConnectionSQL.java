package com.polytech.bsm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {

	private static String url = "jdbc:mysql://localhost:3306/JDBC";
	private static String user = "root";
	private static String password = "aqwzsx85";
	private static Connection connection;
	
	public static Connection getInstance() {
		
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
}
