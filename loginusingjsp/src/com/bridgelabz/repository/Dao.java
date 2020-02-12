package com.bridgelabz.repository;


import java.sql.Connection;
import java.sql.DriverManager;


public class Dao {
	private static Connection con;

	private Dao() {
	};

		static {
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=Sai@0728";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			System.out.println("connection...");

		} catch (Exception e) {

			e.printStackTrace();
			 }
	}

	public static Connection DbConnection() {
		return con;
	}
	


}


