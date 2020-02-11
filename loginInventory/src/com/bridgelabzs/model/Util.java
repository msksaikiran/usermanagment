package com.bridgelabzs.model;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Util {
	private static Connection con;

	private Util() {
	};

		static {
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=Sai@0728";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url);
			System.out.println("connection...");

		} catch (Exception e) {

			e.printStackTrace();
			 }
	}

	public static Connection DbConnection() {
		return con;
	}
	
	public static JSONArray readFile()  {
		 JSONParser jsonParser = new JSONParser();
		FileReader reader=null;
		JSONArray obj = null;
		try {
			reader = new FileReader("/home/user/Desktop/stock24.json");
			obj = (JSONArray) jsonParser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Read JSON file
		
		return obj;
	}

}


