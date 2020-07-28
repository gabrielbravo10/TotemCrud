package com.totemti.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/TotemTI";  
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static Connection connection = null;
	
	
	
	public static Connection openConnection() {
		
		if (connection != null) {
			return connection;
		} else {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			return connection;
		}
		
	}

}
