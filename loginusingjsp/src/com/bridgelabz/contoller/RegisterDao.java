package com.bridgelabz.contoller;

import java.sql.*;

import com.bridgelabz.repository.Dao;

public class RegisterDao {

	public static int register(String fname,String password,String num,String gender,String address) {
		int status = 0;
		try {
			Connection con = Dao.DbConnection();
			PreparedStatement ps = con.prepareStatement("insert into login.loginjsp values(?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, password);
			ps.setInt(3, Integer.parseInt(num));
			ps.setString(4, gender);
			ps.setString(5, address);
			status = ps.executeUpdate();
			
		} catch (Exception e) {
	}

		return status;
	}

}
